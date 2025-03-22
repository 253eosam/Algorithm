import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  lang: 'ko-KR',
  title: 'algo-wiki',
  description: 'A VitePress Site',
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: '홈', link: '/' },
      { text: '이론', link: '/theory' },
      { text: '문제풀이', link: '/problems' },
    ],

    sidebar: {
      theory: [
        {
          text: '자료구조',
          items: [
            { text: 'Markdown Examples', link: '/markdown-examples' },
            { text: 'Runtime API Examples', link: '/api-examples' },
          ],
        },
        {
          text: '알고리즘',
          items: [
            { text: 'Markdown Examples', link: '/markdown-examples' },
            { text: 'Runtime API Examples', link: '/api-examples' },
          ],
        },
      ],
      problems: [
        {
          text: 'codility',
          items: [
            { text: 'BinaryGap', link: '/problems/codility/BinaryGap' },
            { text: 'CountDiv', link: '/problems/codility/CountDiv' },
            { text: 'CyclicRotation', link: '/problems/codility/CyclicRotation' },
            { text: 'FrogJump', link: '/problems/codility/FrogJump' },
            { text: 'FrogRiverOne', link: '/problems/codility/FrogRiverOne' },
            { text: 'MaxCounter', link: '/problems/codility/MaxCounter' },
            { text: 'MissingInteger', link: '/problems/codility/MissingInteger' },
            { text: 'OddOccurrencesInArray', link: '/problems/codility/OddOccurrencesInArray' },
            { text: 'PassingCar', link: '/problems/codility/PassingCar' },
            { text: 'PermCheck', link: '/problems/codility/PermCheck' },
            { text: 'PermMissingElem', link: '/problems/codility/PermMissingElem' },
            { text: 'TapeEquilibrium', link: '/problems/codility/TapeEquilibrium' },
          ]
        }
      ]
    },

    socialLinks: [{ icon: 'github', link: 'https://github.com/vuejs/vitepress' }],
  },
})
