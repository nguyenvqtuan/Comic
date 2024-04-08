import React from 'react'
import Widget from './Widget'
import SearchingContent from './SearchingContent'

const Search = () => {
  return (
    <div className="page-wrapper">
        <div className="container">
            <div className="row">
                <Widget />
                <SearchingContent />
            </div>
        </div>
    </div>
  )
}

export default Search