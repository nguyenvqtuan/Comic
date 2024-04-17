import React from "react";
import ChapterContent from "./ChapterContent";
import ChapterComment from "./ChapterComment";
import CommentForm from "./CommentForm";
import { useParams } from "react-router-dom";

const ComicChapter = () => {
	const params = useParams();
	return (
		<section className="page-wrapper">
			<div className="container">
				<div className="row">
					<div className="col-md-12">
						<div className="post post-single">
							<ChapterContent comicId={params.comicId} id={params.id} />
							<ChapterComment />
							<CommentForm />
						</div>
					</div>
				</div>
			</div>
		</section>
	);
};

export default ComicChapter;
