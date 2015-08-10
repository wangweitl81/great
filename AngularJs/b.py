import json
jsonstr = '{"RET_CODE":0,"RET_MESSAGE":"成功","RESULTSET":[{"SALE_AGNT_TP_CODE":\
    "8888","ECIF_ID":"62000011797846","CUST_ST_CODE":"XA"}],"RECORD_NUM":1}'
obj = json.loads(jsonstr)
print(obj["RESULTSET"][0]['ECIF_ID'])
