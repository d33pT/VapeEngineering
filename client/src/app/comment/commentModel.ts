import {User} from '../user';
import {Post} from '../post/post';

export interface Comment {

  id: number;
  title: string;
  text: string;
  creationDate: string;
  user: User;
  post: Post;
}
