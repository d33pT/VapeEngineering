import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { PostComponent } from './post/post.component';
import {FormsModule} from '@angular/forms';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import { ConfiguratorComponent } from './configurator/configurator.component';
import { AboutUsComponent } from './aboutUs/about-us.component';
import { ProjectStatusComponent } from './projectStatus/project-status.component';
import {CommentComponent} from './comment/comment.component';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    ConfiguratorComponent,
    AboutUsComponent,
    ProjectStatusComponent
    ConfiguratorComponent,
    CommentComponent
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
