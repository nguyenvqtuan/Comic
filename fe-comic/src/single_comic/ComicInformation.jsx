import React from "react";

export const ComicInformation = ({ comic }) => {
	return (
		<div className="project-details">
			{console.log(comic)}
			<h4>{comic?.title}</h4>
			<ul>
				<li>
					<span>
						<i className="fa fa-shirtsinbulk"></i> Category
					</span>
					<strong>{comic?.categoryName}</strong>
				</li>
				<li>
					<span>
						<i className="fa fa-shield"></i> Chapter
					</span>
					<strong>{comic?.countChapter}</strong>
				</li>
				<li>
					<span>
						<i className="fa fa-ils"></i> Status
					</span>
					<strong>{comic?.status}</strong>
				</li>
				<li>
					<span>
						<i className="icon-calendar3"></i>Follow
					</span>{" "}
					{comic?.follow}
				</li>
				<li>
					<span>
						<i className="icon-lightbulb"></i>View
					</span>
					{comic?.view}
				</li>
			</ul>
		</div>
	);
};
