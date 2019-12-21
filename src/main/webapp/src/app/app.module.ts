import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestSoapComponent } from './test-soap/test-soap.component';
import { AppRoutingModule } from './app-routing.module';
import { IntroductionComponent } from './introduction/introduction.component';
import { PerformanceComponent } from './performance/performance.component';

@NgModule({
  declarations: [
    AppComponent,
    TestSoapComponent,
    IntroductionComponent,
    PerformanceComponent],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
