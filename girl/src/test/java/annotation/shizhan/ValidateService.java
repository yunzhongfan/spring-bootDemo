package annotation.shizhan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import annotation.shizhan.Validate.ValidateType;

public class ValidateService {

	public void validateSeeRequest(Object requset, StringBuffer stringBuffer) throws Exception, Exception {
		List<Field> fieldList = new ArrayList<Field>();
		//getDeclaredFields 返回
		// Field对象的一个数组，这些对象反映此 Class
		// 对象所表示的类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。返回数组中的元素没有排序，也没有任何特定的顺序。如果该类或接口不声明任何字段，或者此
		// Class 对象表示一个基本类型、一个数组类或 void，则此方法返回一个长度为 0 的数组。
		fieldList.addAll(Arrays.asList(requset.getClass().getDeclaredFields())); 
		for (Field field : fieldList) {
			field.setAccessible(true);
			Validate validate = field.getAnnotation(Validate.class);
			if (validate != null) {
				if (validate.value() == ValidateType.OBJECT) {
					Object object = field.get(requset);
					if (object != null) {
						validateSeeRequest(object, stringBuffer);
					} else {
						RuleReturn ruleReturn = notBlank_OBJ(field, validate, stringBuffer);
						if (!ruleReturn.isFlag()) {
							stringBuffer.append("Q:").append(ruleReturn.getErrorMsg()).append(";");
							if ("break".equals(ruleReturn.getType())) {
								return;
							}
						}
					}

				} else if (validate.value() == ValidateType.LIST) {
					Object subList = field.get(requset); // 属性
					if (subList != null) {
						List<?> list = (List<?>) subList;
						for (int i = 0; i < list.size(); i++) {
							Object subObj = list.get(i);
							validateSeeRequest(subObj, stringBuffer);
						}
					}
				}
			}
			ValidateRules validateRules = field.getAnnotation(ValidateRules.class);
			if (validateRules == null) {
				continue;
			}
			ValidateRule[] rules = validateRules.value();
			for (ValidateRule validateRule : rules) {
				String methodName = validateRule.ruleName();
				Class<?>[] clazzs = { Field.class, Object.class, ValidateRule.class };
				Method method = this.getClass().getMethod(methodName, clazzs);
				Object[] params = { field, requset, validateRule };
				RuleReturn ruleReturn = (RuleReturn) method.invoke(this, params);
				if (!ruleReturn.isFlag()) { // 校验未通过
					stringBuffer.append("Q:").append(ruleReturn.getErrorMsg()).append(";");
					if ("break".equals(ruleReturn.getType())) {
						break;
					}
				}
				if (ruleReturn.getType().equals(RuleReturn.BREAK)) {
					break;
				}
			}

		}
	}

	private RuleReturn notBlank_OBJ(Field field, Validate validate, StringBuffer stringBuffer) {
		RuleReturn ruleReturn = RuleReturn.SUCCESS;

		if (validate.notBlank()) {
			field.setAccessible(true);
			ruleReturn = new RuleReturn(RuleReturn.BREAK, validate.errorMsg());
		}

		return ruleReturn;
	}

	public RuleReturn notBlank(Field field, Object obj, ValidateRule validateRule) throws Exception {
		String value = field.get(obj) != null ? (String) field.get(obj) : "";

		if (StringUtils.isBlank(value)) {
			return new RuleReturn(RuleReturn.BREAK, validateRule.errorMsg());
		}
		return RuleReturn.SUCCESS;
	}

	public RuleReturn date_v(Field field, Object obj, ValidateRule validateRule) throws Exception {
		String value = field.get(obj) != null ? (String) field.get(obj) : "";
		String date = validateRule.params();
		if (!StringUtils.isBlank(value)) {
			try {
				new SimpleDateFormat(date).parse(value);
			} catch (Exception e) {
				return new RuleReturn(RuleReturn.BREAK, validateRule.errorMsg());
			}
		}
		return RuleReturn.SUCCESS;
	}
}