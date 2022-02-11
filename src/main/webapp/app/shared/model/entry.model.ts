import { Emoji } from 'app/shared/model/enumerations/emoji.model';
import { Blog, IBlog } from './blog.model';

export interface IEntry {
  id?: number;
  title?: string;
  emoji?: Emoji;
  content?: any;
  blogName?: string;
  blogId?: number;
  blog?: IBlog;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class Entry implements IEntry {
  constructor(
    public id?: number,
    public title?: string,
    public emoji?: Emoji,
    public content?: any,
    public blogName?: string,
    public blogId?: number,
    public blog?: Blog,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {}
}
