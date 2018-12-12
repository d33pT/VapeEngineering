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
  };

  constructor(private http: HttpClient) { }

  /** Anfrage an backend zur Adresse api/post; angefragt wird eine Liste <Post>,
   subscribe bedeutet: informiere mich über jede Änderung in Post und speichere sie in p **/

  ngOnInit() {
    this.http.get<Post[]>('/api/forum').subscribe(
      p => this.posts = p
    );
  }

  /** Nachricht an backend; .post muss dabei immer weitere Info mitschicken, hier: this.newPost
   mit der Bitte um Speicherung im backend, dort entnimmt das PostMapping diese Info aus dem
   @RequestBody **/

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
