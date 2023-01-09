(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("post");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><Column id=\"작성자\" type=\"STRING\" size=\"256\"/><Column id=\"작성일\" type=\"STRING\" size=\"256\"/><Column id=\"주차\" type=\"STRING\" size=\"256\"/><Column id=\"사업본부\" type=\"STRING\" size=\"256\"/><Column id=\"팀\" type=\"STRING\" size=\"256\"/><Column id=\"파트\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"작성자\">이용훈 사원</Col><Col id=\"작성일\">2023.01.06</Col><Col id=\"주차\">3</Col><Col id=\"사업본부\">서비스혁신사업부</Col><Col id=\"팀\">제조운영 2팀</Col><Col id=\"파트\">테크윈 파트</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset01", this);
            obj._setContents("<ColumnInfo><Column id=\"직급\" type=\"STRING\" size=\"256\"/><Column id=\"성명\" type=\"STRING\" size=\"256\"/><Column id=\"담당업무\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"직급\">대리</Col><Col id=\"성명\">윤수림</Col><Col id=\"담당업무\">PLM 시스템 운영</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset02", this);
            obj._setContents("<ColumnInfo><Column id=\"활동내용\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset03", this);
            obj._setContents("<ColumnInfo><Column id=\"배운점및소감\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("Dataset04", this);
            obj._setContents("<ColumnInfo><Column id=\"버디피드백\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","30","27","178","44",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("작성자 정보");
            obj.set_font("normal 18pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","40","71","1201","69",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_binddataset("Dataset00");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"164\"/><Column size=\"198\"/><Column size=\"168\"/><Column size=\"237\"/><Column size=\"213\"/><Column size=\"219\"/></Columns><Rows><Row size=\"30\" band=\"head\"/><Row size=\"36\"/></Rows><Band id=\"head\"><Cell text=\"작성자\"/><Cell col=\"1\" text=\"작성일\"/><Cell col=\"2\" text=\"주차\"/><Cell col=\"3\" text=\"사업본부\"/><Cell col=\"4\" text=\"팀\"/><Cell col=\"5\" text=\"파트\"/></Band><Band id=\"body\"><Cell text=\"bind:작성자\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:작성일\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:주차\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:사업본부\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:팀\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:파트\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","31","160","178","44",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("버디 정보");
            obj.set_font("normal 18pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","40","204","860","66",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("Dataset01");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"253\"/><Column size=\"220\"/><Column size=\"385\"/></Columns><Rows><Row size=\"30\" band=\"head\"/><Row size=\"33\"/></Rows><Band id=\"head\"><Cell text=\"직급\"/><Cell col=\"1\" text=\"성명\"/><Cell col=\"2\" text=\"담당업무\"/></Band><Band id=\"body\"><Cell text=\"bind:직급\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:성명\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:담당업무\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","31","300","178","44",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("내용 작성");
            obj.set_font("normal 18pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid02","40","350","1201","92",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_binddataset("Dataset02");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"1199\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"64\"/></Rows><Band id=\"head\"><Cell text=\"활동내용\"/></Band><Band id=\"body\"><Cell text=\"bind:활동내용\" wordWrap=\"english\" maskedittype=\"string\" displaytype=\"text\" edittype=\"textarea\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid03","40","444","1201","92",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("Dataset03");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"1199\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"63\"/></Rows><Band id=\"head\"><Cell text=\"배운점및소감\"/></Band><Band id=\"body\"><Cell text=\"bind:배운점및소감\" edittype=\"text\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid04","40","544","1201","92",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_binddataset("Dataset04");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"1198\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"65\"/></Rows><Band id=\"head\"><Cell text=\"버디피드백\"/></Band><Band id=\"body\"><Cell text=\"bind:버디피드백\" edittype=\"text\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","437","656","187","48",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("저장");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","657","656","187","48",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("제출");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("post.xfdl", function() {

        this.Static00_00_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Static01.addEventHandler("onclick",this.Static00_00_onclick,this);
            this.Static02.addEventHandler("onclick",this.Static00_00_onclick,this);
        };
        this.loadIncludeScript("post.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
