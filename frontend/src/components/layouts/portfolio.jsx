
import { ToastContainer, toast } from 'react-toastify'

import axios from 'axios'


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
    const [projects, setProjects] = useState([]);
    const [preview, setPreview] = useState(3)


    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);

    useEffect(() => {
        axios.get('https://cflceb.hospedagemelastica.com.br/Painel/webresources/generic/returnpost')
            .then((response) => {
                const projectsData = response.data.slice(0, 6);
                setProjects(projectsData);
                toast.info('Projetos Recebidos!', {
                    autoClose: 700,
                    theme: "dark",
                })
            })
            .catch((err) => {
                console.error('Erro ao buscar os dados', err)
                toast.error('Erro ao Receber os projetos.', {
                    closeOnClick: false,
                    draggable: true,
                })
            })
    }, [])

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

                {projects.map((item) => (
                    <SwiperSlide key={item[0]}>
                       <Link to="/project"
                        state={{ projectData: item }}
                    >

                            <img
                                src={item[4]}
                                alt='Logo_teste'
                                className='slide-item'
                            />
                        </Link>
                        <h4>{item[1]}</h4>
                       
                    </SwiperSlide>
                ))}
            </Swiper>

            <Link className='btn_projetos'  to="/portfolio"> Veja todos os projetos</Link>
        </div>

    )
}

export default Portfolio