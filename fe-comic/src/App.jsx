import React from 'react'
import {Route, Routes, BrowserRouter} from 'react-router-dom'
import Nvarbar from './common/Nvarbar'
import Footer from './common/Footer'
import ScrollTop from './common/ScrollTop'
import Slidebar from './common/Slidebar'
import Home from './home/Home'
import Search from './search/Search'
import Comic from './single_comic/Comic'
import ComicChapter from './comic_chapter/ComicChapter'

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Nvarbar />
        <Slidebar />
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/search" element={<Search/>} />
          <Route path="/comic" element={<Comic/>} />
          <Route path="/comic/chapter/:id" element={<ComicChapter/>} />
        </Routes>   
      </BrowserRouter>
   
      <Footer />
      <ScrollTop />
    </div>
  )
}

export default App