import React from 'react'
import ChapterContent from './ChapterContent'
import ChapterComment from './ChapterComment'
import CommentForm from './CommentForm'

const ComicChapter = () => {
  return (
    <section className="page-wrapper">
	<div className="container">
		<div className="row">
        <div className="col-md-12">
				<div className="post post-single">
            <ChapterContent />
            <ChapterComment />
            <CommentForm />
            </div>
            </div>
        </div>
        </div>
</section>
  )
}

export default ComicChapter