import React from 'react'
import Nvarbar from './common/Nvarbar'
import Footer from './common/Footer'
import ScrollTop from './common/ScrollTop'
import Rating from './index/Rating'
import Lastest from './index/Lastest'
import Carousel from './index/Carousel'
import Slidebar from './common/Slidebar'

const App = () => {
  return (
    <div>
      <Nvarbar />
      <Slidebar />
      <div>
        <Rating />
        <Lastest />
        <Carousel />
      </div>
      <Footer />
      <ScrollTop />
    </div>
  )
}

export default App