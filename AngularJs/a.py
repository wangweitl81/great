import urllib
import urllib.request
import json

names = ['曹星', '李宏', '肖波', '王洁琛', '刘召清']
ids = [
    '654226197703210014', '362301196104210517',
    '370321197609240017', '362132198103150033', '512224197211097726'
]

url = ('http://esb.citicsinfo.com'
       '/open/accountx/customer/registerWithThreeElements.json')

for x in range(0, 5):
    values = dict(CUST_NM=names[x], DOC_TP_CODE='10100', DOC_NBR=ids[x])
    data = urllib.parse.urlencode(values)
    data = data.encode('utf-8')  # data should be bytes
    req = urllib.request.Request(url, data)
    resp = urllib.request.urlopen(req)
    respData = resp.read().decode('utf-8')
    obj = json.loads(respData)
    print obj["RESULTSET"][0]['ECIF_ID'], names[x], ids[x]
