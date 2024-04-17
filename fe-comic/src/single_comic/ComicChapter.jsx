import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import ApiClient from "../assets/js/ApiClient";

const ComicChapter = ({ comicId }) => {
	const [chapter, setChapter] = useState();

	useEffect(() => {
		fetchComicChapter();
	}, []);

	const fetchComicChapter = async () => {
		const response = await ApiClient.get(`/comic/${comicId}/chapter`).then(
			(r) => r.data
		);
		setChapter(response);
	};

	return (
		<div id="chapter-list">
			<div className="mb-3">
				<h3>Chapter list</h3>
			</div>

			<div className="row mt-2">
				{chapter?.map((item) => (
					<div className="col-4" key={item.id}>
						<Link to={{ pathname: `/comic/${comicId}/chapter/${item.id}` }}>
							<div className="text-overflow-1-lines mb-2 py-2  border-bottom">
								{item.title}
								<small className="text-muted"> ({item.updatedAt})</small>
							</div>
						</Link>
					</div>
				))}
			</div>
		</div>
	);
};

export default ComicChapter;
