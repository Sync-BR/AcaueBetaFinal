

import { Swiper, SwiperSlide } from 'swiper/react'
import { register } from 'swiper/element/bundle'
register();
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/scrollbar';
import './feedback.css'

const FeedBack = () => {

    const commit = "lorem Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quod.Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quodyy."

    const commitResponsive = "lorem Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit tempora perspiciatis saepe id? Suscipit illo totam quos voluptate esse atque temporibus, commodi magni dolores repellendus deserunt placeat odio, animi quodR."

    const feedBack = [
        { id: '1', name: "Yann o Brabo", commitResponsive: commitResponsive, commit: commit },
        { id: '2', name: "Acaue o Brabo", commitResponsive: commitResponsive, commit: commit },
        { id: '3', name: "Sync o Brabo", commitResponsive: commitResponsive, commit: commit },
        { id: '4', name: "ShoTWD o Brabo", commitResponsive: commitResponsive, commit: commit },
        { id: '5', name: "DsVrog o Brabo", commitResponsive: commitResponsive, commit: commit },
        { id: '6', name: "400kg o Brabo", commitResponsive: commitResponsive, commit: commit }
    ]

    return (
        <div className="container_feedback">
            <div className="title_feedback">
                <p >Feedback</p>
                <span></span>
            </div>
            <h2>Dos nossos Clientes </h2>
            <Swiper
                slidesPerView={1}
                navigation>

                {feedBack.map((item) => (
                    <SwiperSlide key={item.id}>
                        <div className="card_feedback">
                            <p>{window.innerWidth <= 768 ? item.commitResponsive : item.commit}</p>
                            <h3>{item.name}</h3>
                        </div>
                    </SwiperSlide>
                ))}
            </Swiper>
        </div>
    )
}

export default FeedBack