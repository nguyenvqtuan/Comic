import React from 'react'
import Nvarbar from './common/Nvarbar'
import Footer from './common/Footer'
import ScrollTop from './common/ScrollTop'
import Slidebar from './common/Slidebar'
import Home from './home/Home'

const App = () => {
  return (
    <div>
      <Nvarbar />
      <Slidebar />
      <Home />
      <Footer />
      <ScrollTop />
    </div>
  )
}

export default App