
import styles from './project_single.module.scss'
import { useLocation } from 'react-router-dom'
import { useEffect } from 'react'
import { BsChatDots } from "react-icons/bs";
import { toast, ToastContainer } from 'react-toastify';

const Project = () => {

    let location = useLocation()
    const projectData = location.state ? location.state.images : null
    const categoryData = location.state ? location.state.categoryName : null



    useEffect(() => {
        window.scrollTo(0, 0);

        if (projectData) {
            toast.info(`Projeto --  ${categoryData}`, {
                autoClose: 1000,
                theme: "dark",
            })
        }
    }, []);

    if (!projectData) {
        return (
            <>

                <h3>No data found for this project.</h3>
            </>
        )
    }

    return (
        <div>
            <ToastContainer closeOnClick={true} position='bottom-left' />
            <div
                className={`${styles.container_project}`}>
                <div className={styles.container_header}>
                    <span></span>
                    <h1>{categoryData}</h1>
                    <span></span>
                </div>
                <img data-index={'0'} className={`${styles.img_first} `} src={`${projectData[0]}`} alt="animes" />
                <p>{projectData[5]} <BsChatDots className={styles.icon_chat} /></p>
                <img data-index={'1'} className={``} src={`${projectData[1]}`} alt="animes" />
                <p>{projectData[7]} <BsChatDots className={styles.icon_chat} /> </p>
                <img data-index={'2'} className={``} src={`${projectData[2]}`} alt="animes" />
                <p>{projectData[9]} <BsChatDots className={styles.icon_chat} /> </p>
                <img data-index={'3'} className={``} src={`${projectData[3]}`} alt="animes" />
                <p>{projectData[11]} <BsChatDots className={styles.icon_chat} /> </p>
            </div>
        </div>
    )
}


export default Project