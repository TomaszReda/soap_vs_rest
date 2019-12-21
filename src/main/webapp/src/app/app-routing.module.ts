import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {TestSoapComponent} from "./test-soap/test-soap.component";
import {IntroductionComponent} from "./introduction/introduction.component";
import {PerformanceComponent} from "./performance/performance.component";
import {AppComponent} from "./app.component";
import {StateComponent} from "./state/state.component";
import {FormatComponent} from "./format/format.component";

const appRoutes: Routes = [
  {
    path: 'stanowosc',
    component: StateComponent,
  },
  {
    path: 'wstep',
    component: IntroductionComponent,
  },
  {
    path: 'wydajnosc',
    component: PerformanceComponent,
  },
  {
    path: 'test',
    component: TestSoapComponent,
  },
  {
    path: 'home',
    component: AppComponent,
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'format',
    component: FormatComponent
  },
];


@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRoutes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
