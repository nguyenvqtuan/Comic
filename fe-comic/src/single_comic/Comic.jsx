import React from 'react'
import ComicContent from './ComicContent'
import OtherComic from './OtherComic'

const Comic = () => {
  return (
    <section className="page-wrapper">
        <div className="container">
            <div className="row">
                <ComicContent />
                <OtherComic />
            </div>
        </div>
    </section>
  )
}

export default Comic