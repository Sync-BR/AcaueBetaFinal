
import styles from './project_single.module.scss'
import { useLocation } from 'react-router-dom'
import { useEffect } from 'react'
import { BsChatDots } from "react-icons/bs";
import { toast, ToastContainer } from 'react-toastify';

const Project = () => {

    let location = useLocation()
    const projectData = location.state ? location.state.projectData : null



    useEffect(() => {
        window.scrollTo(0, 0);

        if (projectData) {
            toast.info(`Projeto --  ${projectData[1]}`, {
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
                    <h1>{projectData[1]}</h1>
                    <span></span>
                </div>
                <img data-index={'0'} className={`${styles.img_first} `} src={`${projectData[4]}`} alt="animes" />
                <p>{projectData[5]} <BsChatDots className={styles.icon_chat} /> </p>
                <img data-index={'1'} className={``} src={`${projectData[6]}`} alt="animes" />
                <p>{projectData[7]} <BsChatDots className={styles.icon_chat} /> </p>
                <img data-index={'2'} className={``} src={`${projectData[8]}`} alt="animes" />
                <p>{projectData[9]} <BsChatDots className={styles.icon_chat} /> </p>
                <img data-index={'3'} className={``} src={`${projectData[10]}`} alt="animes" />
                <p>{projectData[11]} <BsChatDots className={styles.icon_chat} /> </p>
            </div>
        </div>
    )
}


export default Project