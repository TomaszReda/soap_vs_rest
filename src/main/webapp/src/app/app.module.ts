import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestSoapComponent } from './test-soap/test-soap.component';
import { AppRoutingModule } from './app-routing.module';
import { IntroductionComponent } from './introduction/introduction.component';
import { PerformanceComponent } from './performance/performance.component';
import { StateComponent } from './state/state.component';
import { FormatComponent } from './format/format.component';

@NgModule({
  declarations: [
    AppComponent,
    TestSoapComponent,
    IntroductionComponent,
    PerformanceComponent,
    StateComponent,
    FormatComponent],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
