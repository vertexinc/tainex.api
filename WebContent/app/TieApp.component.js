System.register(['angular2/core', './Body.component', './Header.component', './Footer.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, Body_component_1, Header_component_1, Footer_component_1;
    var TieAppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (Body_component_1_1) {
                Body_component_1 = Body_component_1_1;
            },
            function (Header_component_1_1) {
                Header_component_1 = Header_component_1_1;
            },
            function (Footer_component_1_1) {
                Footer_component_1 = Footer_component_1_1;
            }],
        execute: function() {
            TieAppComponent = (function () {
                function TieAppComponent() {
                }
                TieAppComponent = __decorate([
                    core_1.Component({
                        selector: 'tie-app',
                        template: "\n    <div id = 'header'><tieapp-header></tieapp-header></div>\n    <div id = 'tiebody'><tieapp-body></tieapp-body></div>\n    <div id = 'footer'><tieapp-footer></tieapp-footer></div>\n    ",
                        directives: [Body_component_1.TieAppBodyComponent, Header_component_1.TieAppHeaderComponent, Footer_component_1.TieAppFooterComponent],
                        styleUrls: ['css_ta2/TieApp.component.css']
                    }), 
                    __metadata('design:paramtypes', [])
                ], TieAppComponent);
                return TieAppComponent;
            }());
            exports_1("TieAppComponent", TieAppComponent);
        }
    }
});
//# sourceMappingURL=TieApp.component.js.map