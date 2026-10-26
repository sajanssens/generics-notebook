import './App.css'

function App() {
    const logo = "https://mybinder.org/badge_logo.svg"
    return (
        <>
            <section id="center">

                <div>
                    <h1>Generics</h1>
                    <h2>
                        Click to launch the lab
                    </h2>
                    <p style={{margin: '20px'}}>
                        <a href="https://mybinder.org/v2/gh/sajanssens/generics-notebook/HEAD?urlpath=notebooks/Generics.ipynb"><img
                            src={logo}/> </a>
                    </p>
                    <p>JFall 2026</p>
                </div>
            </section>

            <div><a href="https://bramjanssens.nl">bramjanssens.nl</a></div>
            <div><a href="https://infosupport.com">infosupport.com</a></div>
        </>
    )
}

export default App
