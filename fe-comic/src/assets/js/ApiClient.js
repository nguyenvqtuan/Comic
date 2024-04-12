import axios from 'axios'

export default axios.create({
    baseURL: "https://webtoon.p.rapidapi.com",
    headers: {
        'X-RapidAPI-Key': '62ade18fc8msh0ab50b44dc07433p1da38ejsne433e1369aa8',
        'X-RapidAPI-Host': 'webtoon.p.rapidapi.com'
    }
})