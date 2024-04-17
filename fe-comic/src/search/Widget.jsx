import React, { useEffect, useState } from "react";
import NewestComic from "./NewestComic";
import Category from "./Category";

const Widget = () => {
	return (
		<div className="col-lg-4 order-1 order-lg-0">
			<div className="pr-0 pr-xl-4">
				<aside className="sidebar pt-5 pt-lg-0 mt-5 mt-lg-0">
					<NewestComic />
					<Category />
				</aside>
			</div>
		</div>
	);
};

export default Widget;
