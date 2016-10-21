import {Component} from 'angular2/core';
import {TieAppBodyComponent} from './Body.component';
import {TieAppHeaderComponent} from './Header.component';
import {TieAppFooterComponent} from './Footer.component';

@Component({
    selector: 'tie-app',
    template: `
    <div id = 'tieapp-header'><tieapp-header></tieapp-header></div>
    <div id = 'tieapp-body'><tieapp-body></tieapp-body></div>
    <div id = 'tieapp-footer'><tieapp-footer></tieapp-footer></div>
    `,

    directives: [TieAppBodyComponent, TieAppHeaderComponent, TieAppFooterComponent],
    styleUrls: ['css_ta2/TieApp.component.css']
})
export class TieAppComponent { }
