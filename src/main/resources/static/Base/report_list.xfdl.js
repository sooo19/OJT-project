(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("report_list");
            this.set_titletext("New Form");
            this.set_border("1px");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"Index\" type=\"STRING\" size=\"256\"/><Column id=\"제목\" type=\"STRING\" size=\"256\"/><Column id=\"제출\" type=\"STRING\" size=\"256\"/><Column id=\"피드백\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"Index\">1</Col><Col id=\"제목\">1주차 주간활동 보고서</Col><Col id=\"제출\"/><Col id=\"피드백\"/></Row><Row><Col id=\"피드백\"/><Col id=\"제출\"/><Col id=\"Index\">2</Col><Col id=\"제목\">2주차 주간활동 보고서</Col></Row><Row><Col id=\"Index\">3</Col><Col id=\"제목\">3주차 주간활동 보고서</Col></Row><Row><Col id=\"Index\">4</Col><Col id=\"제목\">4주차 주간활동 보고서</Col></Row><Row><Col id=\"Index\">5</Col><Col id=\"제목\">5주차 주간활동 보고서</Col></Row><Row><Col id=\"Index\">6</Col><Col id=\"제목\">6주차 주간활동 보고서</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","57","50","310","30",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("제조운영2팀 테크윈파트");
            obj.set_font("normal bold 20pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","57","90","143","32",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("이용훈 사원");
            obj.set_font("normal bold 20pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","57","150","761","480",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_binddataset("Dataset00");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"100\"/><Column size=\"500\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"50\" band=\"head\"/><Row size=\"50\"/></Rows><Band id=\"head\"><Cell text=\"Index\" background=\"#cd7f13\" border=\"1px solid\" font=\"normal bold 15px/normal &quot;Arial&quot;\"/><Cell col=\"1\" text=\"제목\" background=\"#cd7f13\" border=\"1px solid\" font=\"normal bold 15px/normal &quot;Arial&quot;\"/><Cell col=\"2\" text=\"제출\" background=\"#cd7f13\" border=\"1px solid\" font=\"normal bold 15px/normal &quot;Arial&quot;\"/><Cell col=\"3\" text=\"피드백\" background=\"#cd7f13\" border=\"1px solid\" font=\"normal bold 15px/normal &quot;Arial&quot;\"/></Band><Band id=\"body\"><Cell text=\"bind:Index\" border=\"1px solid\" textAlign=\"center\" background=\"#c1c1c1\" font=\"normal bold 15px/normal &quot;Gulim&quot;\"/><Cell col=\"1\" text=\"bind:제목\" border=\"1px solid\" padding=\"1px\" background=\"#c1c1c1\" font=\"normal bold 15px/normal &quot;Gulim&quot;\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:제출\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\" border=\"1px solid\" background=\"#c1c1c1\"/><Cell col=\"3\" text=\"bind:피드백\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\" border=\"1px solid\" background=\"#c1c1c1\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("report_list.xfdl", function() {
        var serviceid;  //DataObject request 통신시 사용한 Service ID

        //화면로딩 완료
        this.Form_Work_onload = function(obj,e)

        {

        };


        this.Static00_onclick = function(obj,e)
        {

        };

        this.Static01_onclick = function(obj,e)
        {

        };

        this.Div00_Static00_onclick = function(obj,e)
        {

        };

        //DataObject 통신 성공시
        this.DataObject00_onsuccess = function(obj,e)
        {
          var strStatus = JSON.parse(e.response).status;
          var strData = JSON.parse(e.response).data;
          var strMsg = JSON.parse(e.response).message;
          var strArea = "";

          serviceid = e.serviceid;
          strArea += "serviceid : " + e.serviceid +"\n\n";
          strArea += "status : " + strStatus +"\n\n";
          strArea += "data : "+JSON.stringify(strData) +"\n\n";
          strArea += "message : "+strMsg +"\n";

          //response 정보 TextArea 표시
          this.TextArea00.set_value(strArea);
        };

        //DataObject 통신 실패시
        this.DataObject00_onerror = function(obj,e)
        {
          alert(e.statuscode +":"+e.errormsg);
          this.TextArea00.set_value(e.statuscode +":"+e.errormsg);
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Static00.addEventHandler("onclick",this.Static00_onclick,this);
            this.Static01.addEventHandler("onclick",this.Static01_onclick,this);
        };
        this.loadIncludeScript("report_list.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
