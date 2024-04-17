import React from "react";

const Introduce = ({ comic }) => {
	return (
		<div id="introduce">
			<div className="row">
				<div className="col-8">{comic.description}</div>
				<div className="col-4">Other comic</div>
			</div>
		</div>
	);
};

export default Introduce;
