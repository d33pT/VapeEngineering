import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PostComponent} from './post/post.component';
import {ConfiguratorComponent} from './configurator/configurator.component';
import {AboutUsComponent} from './aboutUs/about-us.component';
import {ProjectStatusComponent} from './projectStatus/project-status.component';
import {ProductComponent} from './product/product.component';
import {CommentComponent} from './comment/comment.component';
import {DevelopmentComponent} from './development/development.component';

const routes: Routes = [
  {path: 'post', component: PostComponent},
  {path: 'configurator', component: ConfiguratorComponent},
  {path: 'aboutUs', component: AboutUsComponent},
  {path: 'projectStatus', component: ProjectStatusComponent},
  // {path: 'forum', component: ForumComponent}
  {path: 'product', component: ProductComponent},
  {path: 'comment', component: CommentComponent},
  {path: 'development', component: DevelopmentComponent}
  /*{path: 'infos', component: InfoComponent}*/
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
