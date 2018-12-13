import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { PostComponent } from './post/post.component';
import {FormsModule} from '@angular/forms';
import { ConfiguratorComponent } from './configurator/configurator.component';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    ConfiguratorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
