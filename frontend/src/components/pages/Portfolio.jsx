import { useEffect, useState, useRef } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import { ToastContainer, toast } from 'react-toastify'
import styles from './portfolio_page.module.scss'
import categoriesImgs from '../../categoriesImgs.json'

const Portfolio = () => {

    const [data, setData] = useState([])
    const [visibleCards, setvisibleCards] = useState([])
    const containerRef = useRef(null);

    useEffect(() => {
        const selectedImages = categoriesImgs.categories.map(category => ({
            category: category.name,
            images: category.images,
        }));
        setData(selectedImages);
    }, []);

    useEffect(() => {
        const observer = new IntersectionObserver((entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    setvisibleCards((prevVisibleCards) => {
                        if (!prevVisibleCards.includes(entry.target.dataset.index)) {
                            return [...prevVisibleCards, entry.target.dataset.index];
                        }
                        return prevVisibleCards
                    })
                } else {
                    setvisibleCards((prevVisibleCards) =>
                        prevVisibleCards.filter((card) => card !== entry.target.dataset.index))
                }
            })
        }, { threshold: 0.4 });

        const cards = containerRef.current.querySelectorAll(`.${styles.card_port}`)
        cards.forEach((card) => observer.observe(card));

        return () => {
            observer.disconnect();
        }
    }, [containerRef.current])


    return (

        <div className={styles.container_port}>
            <ToastContainer closeOnClick={true} />
            <div className={styles.container_header}>
                <span></span>
                <h1>PORTFOLIO</h1>
                <span></span>
            </div>
            <div ref={containerRef} className={styles.container_cards}>
                {data.map((item, index) => (

                    <Link
                        className={`${styles.card_port} ${visibleCards.includes(index.toString()) && styles.visible}`}
                        key={index}
                        to="/project"
                        state={{ categoryName: item.category, images: item.images }}
                        data-index={index.toString()}
                    >
                        <div >
                            <img className={styles.img_first} src={`${item.images[0]}`} alt="foto_portfolio" />
                            <h3> {item.category}</h3>
                        </div>

                    </Link>
                ))}
            </div>
        </div>
    )
}

export default Portfolio

