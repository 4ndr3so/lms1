import '@testing-library/jest-dom'
import { render, screen } from '@testing-library/react'
import Page from './page'

describe('Page', () => {
    it('renders a heading', () => {
        render(<Page />)

        const heading = screen.getByRole('img', { name: /next\.js logo/i })

        expect(heading).toBeInTheDocument()
    })
})
