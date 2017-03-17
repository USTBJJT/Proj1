package cn.edu.ustb.mt4ws.mr;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.edu.ustb.mt4ws.mr.model.Operator;
import cn.edu.ustb.mt4ws.mr.model.Relation;
import cn.edu.ustb.mt4ws.mr.model.RelationOfInput;
import cn.edu.ustb.mt4ws.tcg.WsdlOperationFormat;
import cn.edu.ustb.mt4ws.tcg.XmlMessageFormat;
import cn.edu.ustb.mt4ws.tcg.XmlTcgUtils;

public class MRUtils {

	/**
	 * 解析expression中operator的类�?
	 * 
	 * @param exp
	 * @return
	 * @throws Exception
	 */
	public static int getOperatorFromExp(String exp) throws Exception {
		int i;
		int opType = -1;
		for (i = 0; i < Operator.ops.length; i++)
			if (exp.contains(Operator.ops[i]))
				if (Operator.ops[i].contains(opType == -1 ? ""
						: Operator.ops[opType]))
					opType = i;

		return opType;
	}

	public static Map<String, Limitation> getLimitionOfSourceTC(
			XmlMessageFormat inputFormat, RelationOfInput relationOfInput) {
		Map<String, Limitation> limitationMap = new LinkedHashMap<String, Limitation>();
		List<String> varList = inputFormat.getVariables();
		Iterator<Relation> iterRelation = relationOfInput.getRelationOfInput()
				.iterator();
		Relation relation = null;
		String functionSource, functionFollowUp = null;
		Operator op = null;
		while (iterRelation.hasNext()) {
			relation = iterRelation.next();
			functionSource = relation.getFunctionSource()
					.getFunctionDescription();
			functionFollowUp = relation.getFunctionFollowUp()
					.getFunctionDescription();
			op = relation.getOp();
			Iterator<String> iterVar = varList.iterator();
			boolean hasLimitation = true;
			while (iterVar.hasNext()) {
				String varName = iterVar.next();
				if (functionFollowUp.contains(varName))
					hasLimitation = false;
			}
			if (hasLimitation == true) {
				Limitation limit = new Limitation();
				if (op.getType() == Operator.GT)
					limit.lower = functionFollowUp;
				else if (op.getType() == Operator.LT)
					limit.upper = functionFollowUp;
				else if (op.getType() == Operator.EQ) {
					limit.lower = functionFollowUp;
					limit.upper = functionFollowUp;
				} else {// TODO 不识别的Operator
					;
				}
				if (limitationMap.containsKey(functionSource) == false)
					limitationMap.put(functionSource, limit);
				else {
					Limitation limitPre = limitationMap.get(functionSource);
					limitPre.merge(limit);
					limitationMap.put(functionSource, limitPre);
				}
			}

		}
		return limitationMap;
	}

	/**
	 * 先假设relation中的op是等号，求出右边表达式的值temp，然后再根据op对这个temp值进行调�?br>
	 * <br>
	 * 比如表达式为a'>2a,先求�?a的�?，然后再根据">"号对2a进行调整(增大即可)
	 * @param operationType
	 *            操作符类�?
	 * @param valueOfSourceDouble
	 *            原始用例的�?
	 * @return
	 */
	public static double getFollowUpValue(double valueOfSourceDouble,
			int operationType) {
		Random ran = new Random();
		double valueOfFollowUpDouble = 0;
		switch (operationType) {
		case Operator.EQ:
			valueOfFollowUpDouble = valueOfSourceDouble;
			break;
		case Operator.GT:
			valueOfFollowUpDouble = valueOfSourceDouble + ran.nextInt(10) + 1;
			break;
		case Operator.LT:
			valueOfFollowUpDouble = valueOfSourceDouble - ran.nextInt(10) - 1;
			break;
		case Operator.NEQ:
			valueOfFollowUpDouble = valueOfSourceDouble + ran.nextInt(10) - 1;
			break;
		case Operator.NGT:
			valueOfFollowUpDouble = valueOfSourceDouble - ran.nextInt(10);
			break;
		case Operator.NLT:
			valueOfFollowUpDouble = valueOfSourceDouble + ran.nextInt(10);
			break;
		default:
			break;
		}
		return valueOfFollowUpDouble;
	}
}
