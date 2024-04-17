import React, { useEffect, useState } from "react";
import ApiClient from "../assets/js/ApiClient";

const ChapterContent = ({ comicId, id }) => {
	const [chapter, setChapter] = useState();
	useEffect(() => {
		fetchChapter();
	}, []);

	const fetchChapter = async () => {
		const response = await ApiClient.get(
			`/comic/${comicId}/chapter/${id}`
		).then((r) => r.data);
		setChapter(response);
	};
	return (
		<div>
			<h2 className="post-title">{chapter?.title}</h2>
			<div className="post-meta">
				<ul>
					<li>
						<i className="ion-calendar"></i> {chapter?.createdAt}
					</li>
					<li>
						<i className="ion-android-people"></i> POSTED BY ADMIN
					</li>
					<li>
						<a href="blog-grid.html">
							<i className="ion-pricetags"></i> LIFESTYLE
						</a>
						,<a href="blog-left-sidebar.html"> TRAVEL</a>,{" "}
						<a href="blog-right-sidebar.html">FASHION</a>
					</li>
				</ul>
			</div>
			<div className="post-thumb">
				<img className="img-fluid" src="images/blog/blog-post-1.jpg" alt="" />
			</div>
			<div className="post-content post-excerpt">
				{chapter?.content?.split(",").map((item) => {
					<img
						className="media-object"
						src={
							"https://drive.google.com/thumbnail?id=" + item.image + "&sz=w650"
						}
						alt="Image"
					/>;
				})}
			</div>
		</div>
	);
};

export default ChapterContent;
