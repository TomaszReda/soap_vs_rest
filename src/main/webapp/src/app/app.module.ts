import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestSoapComponent } from './test-soap/test-soap.component';
import { AppRoutingModule } from './app-routing.module';
import { IntroductionComponent } from './introduction/introduction.component';
import { PerformanceComponent } from './performance/performance.component';
import { StateComponent } from './state/state.component';
import { FormatComponent } from './format/format.component';
import { CacheComponent } from './cache/cache.component';
import { ProtocolComponent } from './protocol/protocol.component';
import { ConfigComponent } from './config/config.component';
import { SecurityComponent } from './security/security.component';
import { EfficiencyComponent } from './efficiency/efficiency.component';
import { DataSizeComponent } from './data-size/data-size.component';
import { DaneComponent } from './dane/dane.component';
import { JavaapiComponent } from './javaapi/javaapi.component';
import { SerwerComponent } from './serwer/serwer.component';
import { UseComponent } from './use/use.component';
import { UtilizationComponent } from './utilization/utilization.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { OthersComponent } from './others/others.component';

@NgModule({
  declarations: [
    AppComponent,
    TestSoapComponent,
    IntroductionComponent,
    PerformanceComponent,
    StateComponent,
    FormatComponent,
    CacheComponent,
    ProtocolComponent,
    ConfigComponent,
    SecurityComponent,
    EfficiencyComponent,
    DataSizeComponent,
    DaneComponent,
    JavaapiComponent,
    SerwerComponent,
    UseComponent,
    UtilizationComponent,
    OthersComponent],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
