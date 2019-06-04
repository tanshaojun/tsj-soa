import re

import scrapy


class ZhongDengWangSpider(scrapy.Spider):
    name = 'zhongdengwang'
    allowed_domains = ['zhongdengwang.org.cn']
    start_urls = ['http://www.1zuyun.com/accountCenter#']

    def start_requests(self):
        cookies = "bdshare_firstime=1547175789534; Hm_lvt_6ec6e860726704758fbcb12c38ad65eb=1547518952,1547606055,1547716452,1548228477; LiveWSPYT25250022=2342c6c0f5fc4177bb865caf58775a33; NPYT25250022fistvisitetime=1550471841405; NPYT25250022IP=%7C61.50.105.174%7C; NPYT25250022lastvisitetime=1550719222588; NPYT25250022visitecounts=2; NPYT25250022visitepages=4; Hm_lvt_3c810bbf608f66272f265c6642590320=1557712856,1557985532,1558058362,1558352191; nb-referrer-hostname=www.1zuyun.com; goldsid=9d40e471-a204-4c4f-9469-c39873789c70; Hm_lpvt_3c810bbf608f66272f265c6642590320=1558352829; nb-start-page-url=http%3A%2F%2Fwww.1zuyun.com%2F%23; rememberMe=3I3ND5N1Z8fpbcm+Lo69q6Y0YF5NYhFncDR8gRuyX3u6MdTmDOZQNDFCEIH6H12bCHy+zi9h+Sr7Sq5oHC3Xrm5PQa7+4wfbiCNZH+8eBTnD2dwpDEjs7QJNo4PfdrXA89YATMovgs2CUtdBd1cOjWez3QoVhl+geg/5RyJx0YeuaB/ADmrZD0XBd2wll5+naec3KkYwIW9vwNCmWh6uNw2v6jQb19xi9Cl0cwEubn+ZuMfSgw+eTEvQahmhB269Vyzy8j6Z6xgnvvEiBdXm+aBGSfDNFRhMAHZqI4VWm8powHIiauk85hYMgJZCg/UTyOUqiaBMS346Cg3kHGlOs5qF4LP9AHi7a5Nn10S0ZXm/gxZAcEnjAW3cezxetKz+5dkbOGkfOtpk+8McEql7Cl0VqW3tEauwGMQ4qKyOGHGTcBn/fbncX2PUZq99bRMVYnzdHdJPGWpzvv64m6ojPrdDNsnNbBIxd1u4c677SqyJnp/i321o59PzQEzUejUqSMBrHwE5GTynVQxXRl/Bc3xe3UdYUyke7fvuSHqFKTQ="
        cookies = {i.split("=")[0]: i.split("=")[1] for i in cookies.split("; ")}
        yield scrapy.Request(
            self.start_urls[0],
            callback=self.parse,
            cookies=cookies
        )

    def parse(self, response):
        print(response.body.decode())
        # yield scrapy.Request(
        #     "http://www.renren.com/327550029/profile?v=info_timeline",
        #     callback=self.parse_detial
        # )

    def parse_detial(self, response):
        print(1)
# print(re.findall("张三", response.body.decode()))
