import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {TestSoapComponent} from "./test-soap/test-soap.component";
import {IntroductionComponent} from "./introduction/introduction.component";
import {PerformanceComponent} from "./performance/performance.component";
import {AppComponent} from "./app.component";
import {StateComponent} from "./state/state.component";
import {FormatComponent} from "./format/format.component";
import {CacheComponent} from "./cache/cache.component";
import {ProtocolComponent} from "./protocol/protocol.component";
import {ConfigComponent} from "./config/config.component";
import {EfficiencyComponent} from "./efficiency/efficiency.component";
import {SecurityComponent} from "./security/security.component";
import {DataSizeComponent} from "./data-size/data-size.component";
import {DaneComponent} from "./dane/dane.component";
import {JavaapiComponent} from "./javaapi/javaapi.component";
import {SerwerComponent} from "./serwer/serwer.component";
import {UtilizationComponent} from "./utilization/utilization.component";
import {UseComponent} from "./use/use.component";

const appRoutes: Routes = [
  {
    path: 'javaAPI',
    component: JavaapiComponent
  },
  {
    path: 'serwer',
    component: SerwerComponent
  },
  {
    path: 'wykorzystanie',
    component: UtilizationComponent
  },
  {
    path: 'zastosowania',
    component: UseComponent
  },
  {
    path: 'wydajnosc',
    component: EfficiencyComponent
  },
  {
    path: 'wydajnosc',
    component: EfficiencyComponent
  },
  {
    path: 'rozmiar-danych',
    component: DataSizeComponent
  },
  {
    path: 'dane',
    component: DaneComponent
  },
  {
    path: 'bezpieczenstwo',
    component: SecurityComponent
  },
  {
    path: 'stanowosc',
    component: StateComponent,
  },
  {
    path: 'cache',
    component: CacheComponent
  },
  {
    path: 'protokol',
    component: ProtocolComponent
  },
  {
    path: 'configuracja',
    component: ConfigComponent
  },
  {
    path: 'wstep',
    component: IntroductionComponent,
  },
  {
    path: 'definicje',
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
