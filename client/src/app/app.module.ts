import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { PostComponent } from './post/post.component';
import {FormsModule} from '@angular/forms';
import { ConfiguratorComponent } from './configurator/configurator.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    ConfiguratorComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
