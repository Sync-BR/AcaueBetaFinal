import MainTitle from "../layouts/mainTitle"
import Portfolio from "../layouts/portfolio"
import AboutUs from "../layouts/aboutUs"
import FeedBack from "../layouts/feedBack"
import FormContact from "../form/formContact"


const Home = () => {

    return (
        <div>
            <MainTitle />
            <Portfolio />
            <AboutUs />
            <FeedBack />
            <FormContact />
        </div>
    )
}

export default Home