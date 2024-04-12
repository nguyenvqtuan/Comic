import React, { useEffect, useState } from 'react'
import Rating from './Rating'
import Lastest from './Lastest'
import Carousel from './Carousel'
import ApiClient from '../assets/js/ApiClient'


const Home = () => {
  const [homes, setHomes] = useState([])
  useEffect(() => {
    fetchHome();
  }, [])

  const fetchHome = async () => {
    const response = await ApiClient.get("/canvas/home?language=en").then((r) => r.data);
    const data = response.message.result;
    setHomes(data)
  }

  return (
    <div>
        <Rating rating={homes.popularByGenreList} />
        <Lastest lastest={homes.weeklyHotByGenreList} />
        {/* <Carousel carousel={homes.weeklyHotTitleList} /> */}
    </div>
  )
}

export default Home