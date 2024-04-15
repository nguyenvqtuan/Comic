import React, { useEffect, useState } from 'react'
import Rating from './Rating'
import Lastest from './Lastest'
import Carousel from './Carousel'

const Home = () => {

  return (
    <div>
        <Rating />
        <Lastest />
        {/* <Carousel carousel={homes.weeklyHotTitleList} /> */}
    </div>
  )
}

export default Home