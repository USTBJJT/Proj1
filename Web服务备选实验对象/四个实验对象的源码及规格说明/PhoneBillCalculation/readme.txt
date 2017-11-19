
不同套餐包括不同的套餐费用（Plan fee）和免费组合：
通信时间限制（Communication time limit）、数据流量限制（Data usage limit）、每分钟通话费用（Call cost per minute）、每分钟流量费用（Call cost per minute）
Plan fee is denoted by “planFee”.
Communication time limit is denoted by “talkTimeBench”.
Data usage limit is denoted by” flowBench”. 
Call cost per minute is denoted by “talkTime per”.
Data cost per minute is denoted by “flowPer”.


bill = extraCallBill + extraDataBill + planFee
总费用为额外通话费用+额外数据费用+套餐费


输入数据为四个：planType（套餐类型）planFee（套餐费用）talkTime（通话时间）flow（使用流量）
输出：总花费