
import { ToastContainer, toast } from 'react-toastify'
import axios from 'axios'
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { Swiper, SwiperSlide } from 'swiper/react'
import { register } from 'swiper/element/bundle'
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import './portfolio.css'

import categoriesImgs from '../../categoriesImgs.json'

register();

const Portfolio = () => {
    const [preview, setPreview] = useState(3)
    const [sliderImages, setSliderImages] = useState([]);



    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);

    useEffect(() => {
        const selectedImages = categoriesImgs.categories.slice(0, 6).map(category => ({
            category: category.name,
            images: category.images,
            image: category.images[0]
        }));
        setSliderImages(selectedImages);
    }, []);

    useEffect(() => {
        function handleResize() {
            if (window.innerWidth <= 620) {
                setPreview(1)
            } else if (window.innerWidth > 620 && window.innerWidth < 1100) {
                setPreview(2)
            } else {
                setPreview(3)
            }
        }
        handleResize()
        window.addEventListener('resize', handleResize)
        return () => window.removeEventListener('resize', handleResize)
    }, [])

    return (
        <div className='container_slide'>
            <div className='title_port'>
                <p>Portfólio</p>
                <span></span>
            </div>
            <h2>Identidade Visual</h2>
            <Swiper
                slidesPerView={preview}
                pagination={{ clickable: true }}
                navigation>

                {sliderImages.map((item) => (
                    <SwiperSlide key={item.category}>
                        <Link to="/project"
                            state={{ categoryName: item.category, images: item.images }}
                        >

                            <img
                                src={item.image}
                                alt='Logo'
                                className='slide-item'
                            />
                        </Link>
                        <h4>{item[1]}</h4>

                    </SwiperSlide>
                ))}
            </Swiper>

            <Link className='btn_projetos' to="/portfolio"> Veja todos os projetos</Link>
        </div>

    )
}

export default Portfolio