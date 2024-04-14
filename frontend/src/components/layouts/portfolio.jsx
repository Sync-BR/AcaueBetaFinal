import logo1 from '../../images/prima.png'
import logo2 from '../../images/segu.png'
import logo3 from '../../images/terc.png'

import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import { Swiper, SwiperSlide } from 'swiper/react'
import { register } from 'swiper/element/bundle'
register();
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import './portfolio.css'


const Portfolio = () => {

    const [preview, setPreview] = useState(3)

    const imgData = [
        { id: '1', image: logo1 },
        { id: '2', image: "https://placehold.jp/230x130.png" },
        { id: '3', image: logo3 },
        { id: '4', image: "https://placehold.jp/230x130.png" },
        { id: '5', image: logo2 },
        { id: '6', image: "https://placehold.jp/230x130.png" }
    ]

    useEffect(() => {
        function handleResize() {
            if (window.innerWidth <= 420) {
                setPreview(1)
            } else if (window.innerWidth > 420 && window.innerWidth < 768) {
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
        <div className="container_slide">
            <div className='title_port'>
                <p>Portfólio</p>
                <span></span>
            </div>
            <h2>Identidade Visual</h2>
            <Swiper
                slidesPerView={preview}
                pagination={{ clickable: true }}
                navigation>

                {imgData.map((img) => (
                    <SwiperSlide key={img.id}>
                        <Link to={`/project/${img.id}`}><img
                            src={img.image}
                            alt="Logo_teste"
                            className='slide-item'
                        />
                        </Link>
                        <h4>Tutulo new</h4>
                        <p>Descrição New</p>
                    </SwiperSlide>
                ))}
            </Swiper>

         
                <Link className='btn_projetos' to="/portfolio"> Veja todos os projetos</Link>
           
        </div>

    )
}

export default Portfolio