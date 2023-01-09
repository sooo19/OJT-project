(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_initvalueid("버디 프로그램");
            this.set_name("main");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Button("Button00","350","375","190","65",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("버디");
            obj.set_font("normal 20pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","685","378","190","65",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("신입사원");
            obj.set_font("normal 20pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","490","203","270","129",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("버디 프로그램");
            obj.set_textAlign("center");
            obj.set_font("normal 30pt/normal \"Arial\"");
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
        this.registerScript("main.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onclick",this.Button01_onclick,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
        };
        this.loadIncludeScript("main.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
