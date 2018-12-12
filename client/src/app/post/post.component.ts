import { Component, OnInit } from '@angular/core';
import {Post} from './post';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  posts: Post[];
  newPost: Post = {
    title: '',
    text: ''
  }

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Post[]>('/api/forum').subscribe(
      p => this.posts = p
    );
  }

  fillForum() {
    this.http.post<Post[]>('/api/forum', this.newPost).subscribe(
      p => this.posts = p
    );
    this.newPost = {
      title: '',
      text: ''
    };
  }

}
