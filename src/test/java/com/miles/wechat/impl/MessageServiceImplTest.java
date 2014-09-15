package com.miles.wechat.impl;

import com.miles.wechat.AbstractBasicTest;
import com.miles.wechat.api.MessageService;
import com.miles.wechat.api.MessageType;
import com.miles.wechat.api.ResponseInfo;
import com.miles.wechat.core.WeChatEngine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageServiceImplTest extends AbstractBasicTest{
    private MessageService messageService;

    @Before
    public void setUp() throws Exception {
        WeChatEngine engine = WeChatEngine.newInstance();
        messageService = engine.getMessageService();
    }

    @Test
    public void testSendToGroup() throws Exception {
        Assert.assertNotNull(messageService);
        ResponseInfo responseInfo = messageService.sendToGroup("0", MessageType.TEXT, "hello ,调试接口");
        if (!responseInfo.isSuccess()) {
            System.out.println(responseInfo.getInfo().getErrorCode());
            System.out.println(responseInfo.getInfo().getErrorMessage());
        }
        Assert.assertNotNull(responseInfo);
        Assert.assertTrue(responseInfo.isSuccess());
    }

    @Test
    public void testSendToUser() throws Exception {
        String users[] = new String[]{"oQ3C4uAyKWVBp4QW8XHn9keZkRIY", "oQ3C4uAYO8pY8iv0DhlAvK9vprs4", "oQ3C4uGp9Qa74dGCZHBkyGnWgkL8", "oQ3C4uATQQWPIDgTU8z6v-dU9p2U", "oQ3C4uDyccBJi3-1sBtV9qVwgkCA", "oQ3C4uP5GVylKIlG_fVpSjj3lkj0", "oQ3C4uPKcrKnzCLVrXnAC9sl2Te8", "oQ3C4uNi3PELQ89ktomd-DrAIj2k", "oQ3C4uMzWTG5gJOsKILeAWNv8X0E", "oQ3C4uDNXijP-qTtWQhUQndnGCZs", "oQ3C4uF2XhNWz2Ai6HeH9QM5AZSs", "oQ3C4uKoDfuoCISnhc29aInGZ7pc", "oQ3C4uJRSRq7Shr121UZ6i-R5Rcs", "oQ3C4uJO9qrGahnBrve1DTQU8H7c", "oQ3C4uOD4ZUz3meI8Vk8vHOvsdOk", "oQ3C4uD3vMik9qwUzmoKAnvl4KlY", "oQ3C4uC7wNgb5LVhXbuE1msbuLQY", "oQ3C4uOvTK20gry6DwluGt5LKmv4", "oQ3C4uEXK_pcxGCWUfqzrXO-7sgw", "oQ3C4uFGbz8W713x2uvycLFfWOyo", "oQ3C4uIgN9MEFRDrf489gFnSzCZM", "oQ3C4uC0AIGjfxOY4R-62nQaKHNI", "oQ3C4uMCqwHSafBDeH3w35GKSRAE", "oQ3C4uJDKxq1X_lFOBOdrHqNRVno", "oQ3C4uD6-BKKWwMPgqwYD4jByK3w", "oQ3C4uN-u_SfBByIjd-BdLqZW6EY", "oQ3C4uM3Ci65hDNTGodWrFEZsEgE", "oQ3C4uMGiislDeNsZ9g2hTb6L6j4", "oQ3C4uKq_5ak27JfnF9eMhdgjgBQ", "oQ3C4uHHWsSGKvRJbaT-KUnDWj8g", "oQ3C4uDu0Zmj7hTSfN3-FfACFw3E", "oQ3C4uJtayKPHVlwRnGeF1pkpwnk", "oQ3C4uEbzCH8TYfHvZmCwt8t_SPg", "oQ3C4uClq_UveEOwctvxOTjZZt0U", "oQ3C4uGOGa7fhHJMlSgMvzFnOvVY", "oQ3C4uAr1ueLA2CBdQ5SByDFp2Yk", "oQ3C4uBkienGSoCSZMYF1096ZWW8", "oQ3C4uAH0CAIqwAW-7r23TBo_8Pw", "oQ3C4uH0NcMy3oJNLaNQA_T2oP20", "oQ3C4uGNxMB6J854ja1BZzhL5EzA", "oQ3C4uI5-d2ZFTpRlfLFB63ZUBlM", "oQ3C4uFlnOtnwgrtb4YevUb5f-WI", "oQ3C4uN-yGp2njPCBqieEGdOAdn8", "oQ3C4uGVeTDfvt8f6UMqxLqWFhiw", "oQ3C4uHmLDulBpZx3abrH6hhIfLI", "oQ3C4uLa6_scxld_GEURnX3DBQ8Y", "oQ3C4uOFZg2X1dlrvMTLx7DIX1t8", "oQ3C4uJPN1ox-wtCHBrqg6fAs0EU", "oQ3C4uKSxDkMV-vmdL27Wdjnir-Q", "oQ3C4uIuIrAR6y3-eFMG31W-oFQ8", "oQ3C4uM5BKTNEMCsXN-euGiZuO5Q", "oQ3C4uEIiSZ8TyYmxkkoOhYKR1Ao", "oQ3C4uGNLco0SyvYKQO4RZbbam9k", "oQ3C4uMK1w-pUmO7cD3YIVvZUAxY", "oQ3C4uJP3ZpQtxcE8Eh2HSjOllmI", "oQ3C4uAo4ATx_ub09DAiEg-eyfLM", "oQ3C4uKB1JszutlyPv0HbIkNrBKU", "oQ3C4uJIYp8mHtmYWUAMRT9DHuV0", "oQ3C4uHvftMz8BoA6o7eTadTbmKM", "oQ3C4uMj0tkNuRF81LMqo3_1vlz4", "oQ3C4uP3R-0KwuenUcK0IGaqrz3Y", "oQ3C4uGsU4vqbczvD9TLDT5AchGs", "oQ3C4uL92tJKY29ulQweCmFLP4Qk", "oQ3C4uK79mOivaWgPEXweCbyPhLc", "oQ3C4uOVeW39oaYERLpjb-Mp_bto", "oQ3C4uGk6XekyHaB_VRM_425_7u0", "oQ3C4uOb2rKQn22eGhhF_y3hq2TA", "oQ3C4uK8yXmRc1XllbNDSEpi0MvI", "oQ3C4uMdTzgXJbZsLvH8HfyvDIbI", "oQ3C4uJlJLNpTuxHaIXxXUiAQbkA", "oQ3C4uL1mOX5mUBN8JE8j89BLmIA", "oQ3C4uGlYCxV9pcY91YqCKUWIpTI", "oQ3C4uAN_Ysfl18Uh04BQF4Utnv8", "oQ3C4uJzYm0JqYRbFTVRwd_-uMkI", "oQ3C4uISm3QIJjwVU6DxFwkyu45I", "oQ3C4uNPnk-XOZ9cc5496bE2ico0", "oQ3C4uG7ecQxci_wvlGd-6TqSmIU", "oQ3C4uIg-zobR7T7sKLyrK5thK1o", "oQ3C4uGqKxgjAMZwp5lVIVcmQ_c0", "oQ3C4uCjKDHzl147OLJBLG2t5EKs", "oQ3C4uGXYV7ckM9cras0I6v_NcAs", "oQ3C4uLHNgjYlXenW7yHf34y5WYs", "oQ3C4uN6dWv63-D-_H7x6B9qamfM", "oQ3C4uABJA_py9-cAuW3VbCJoAAI", "oQ3C4uFuiWGN12XrIF4L0iO8CF9M", "oQ3C4uL4_0AGkH_NuJeaD20qec2s", "oQ3C4uD9mp5Qoc_svbpbr4SHLJDM", "oQ3C4uOiGiZxRkwmz252LVXJbPDI", "oQ3C4uAdyYubeSvL7m0h3ChdAoq8", "oQ3C4uHSWBjp5Z7TnG08vhICkXhE", "oQ3C4uOUw0_R015TH2F9NEXEoKZ4", "oQ3C4uCyP8I_JePlmqhRKfKNP5W4", "oQ3C4uEeVmJZ-0r-fMITyReVvUi0", "oQ3C4uOJU3bUerRRtM7A6mTcXYKw", "oQ3C4uCdrDkvBfxcGR0vs_8Wd4_E", "oQ3C4uPN1mWYvBaEIs6lrVCgdTs4", "oQ3C4uDLUhwUbNWQyjQZG0t1zYg8", "oQ3C4uON2cjfLbeXEgN9fBDJPHcc", "oQ3C4uAm8h9FlOxpFmKQUc1KbxLQ", "oQ3C4uKtwUBX7IG2rpVBiHOFmm5E", "oQ3C4uMgv5rp76m3_5ZFy7F97ciM", "oQ3C4uAK6G19IY1UnVby-oeghYwE", "oQ3C4uEQ6HPxBvN7ktz45d3k31n8", "oQ3C4uLmiZ3T1yOL2Slml_ciJ9Fs", "oQ3C4uAzZpGXxsWL3F1KSrhwjfl8", "oQ3C4uGpEl8g8t78-YjLCNIqZwfg", "oQ3C4uEKvjEEV_mFDSJb2UyNdW7o", "oQ3C4uOWvNSMSvKaFX5PCaN_NPjU", "oQ3C4uAvFMGYcig_DzZf1YJT5lQc", "oQ3C4uGFiaPa9KBVoDnH-Bzf-aVE", "oQ3C4uKrfU8Su1vJf7XerHcLPMjE", "oQ3C4uHCHBQPYh7rb86k3PF3n3lU", "oQ3C4uAlaghMu2rsHTGQPDQZef3E", "oQ3C4uCeVJJMFulSOp_UUNYSpsUk", "oQ3C4uO9FG4BUwuTezOQpQNpY8Qs", "oQ3C4uKzg-17PVGLcwLtpU-wCKoY", "oQ3C4uM0uTBKAVgvRrsAb8_VAcl0", "oQ3C4uL_b5tusIeLECLgLN-krbio", "oQ3C4uAiEe7CCTCpPy7lWOLlsEGc", "oQ3C4uLpvNNdNngIEto6lF3m4bpE", "oQ3C4uIwXdmZ0IjiQc9vL2380_Hc", "oQ3C4uH4VKFqeMD02PuT6vY23S_Y", "oQ3C4uDf2gdMLy7cg5j1c0D1-hug", "oQ3C4uJ85Tijt6yoCWyv2PeyHPHs", "oQ3C4uIMHGW0g_DBc_Vf4BTgzYoU", "oQ3C4uEazeN4SzKZ6PTsuaAeXW8g", "oQ3C4uB0lbfM3o7UDw_bX1sHGqCA", "oQ3C4uMBtUJCQsat7IYkuhF3Pqa8", "oQ3C4uPPVg3YFfssZnt-0-RDBAk8", "oQ3C4uJiUDkEczDF5fMDJBXoKqeE", "oQ3C4uLzTCmzJa7qJ0HilW2_x8BU", "oQ3C4uM0oj9a7H7-dBQxrN0prMf0", "oQ3C4uKDnWDKSP12WcqTfrjKcicA", "oQ3C4uG4A9ftD-1I74__sI_JsgvA", "oQ3C4uDYgYgnOUROW0DZLC32fWes", "oQ3C4uE5k4uYnIo90p8VytC_bhIw", "oQ3C4uPUErYLKD7PLREFa7Kbn_6g", "oQ3C4uJ89D8ieEltH2Ny5ln012N4", "oQ3C4uE_ujjDOwLLlxChIOQACCwI", "oQ3C4uGzsnmUFLNdybC_020u9pMg", "oQ3C4uCcuSTrz_vYJ-wopPK439YI", "oQ3C4uBBPBvU_gwIzCyov4t2IGzI", "oQ3C4uDmBaJyCgdGyiLl5MFlKOyU", "oQ3C4uGSVbb0YWJ0OlgNJGpHx7j4", "oQ3C4uJN72ZyVDWwF4kfLZN2uS2g", "oQ3C4uB3lUH4bg74Mfg_9V_fyy48", "oQ3C4uPZ7PMVhnYq5t8_kqW4uQjw", "oQ3C4uBYeKGl3CXZQmawCacDnBq0", "oQ3C4uJrOou3IddxRiUlL6Cxs1yg", "oQ3C4uIs9Fvt05Fba4g8WIz6ps10", "oQ3C4uKaElwxDerV71fvVFKuX_zg", "oQ3C4uLTeVIn2HQPIBk8KD9DGIjs", "oQ3C4uGItjRcT_atcxoK6rDSHczk", "oQ3C4uAnBTl37nuQZsQV0ikBD0Z8", "oQ3C4uC6YEBYOOzXvHjh7fAWxMHo", "oQ3C4uIln7YpVTIJ4sxv_GJkDJkM", "oQ3C4uCxYZOezbG8fy_pyXOxnA-8", "oQ3C4uG7N1qbvsNNZw4TPqSTrv8c", "oQ3C4uHVQM1Xb79QRHBeduvGk_fU", "oQ3C4uGMjfZjSIYfezwK_bcdz8uI", "oQ3C4uCY7nv-ul_S3h3sDHdJ92Ko", "oQ3C4uG1Uqv_BXJyY--2HFh3__7c", "oQ3C4uL63i45O3gN4e1KvyUoTtiw", "oQ3C4uDvODt9qx7AC7WieVAGQXdY", "oQ3C4uO-iUYWInqWkElIoxSqcJns", "oQ3C4uK43RIBARyEW28B5DUfvDl0", "oQ3C4uKibuawOiapP41mc4sb3bOc", "oQ3C4uJ8f5HN-1oWuszpcUtP8ojg", "oQ3C4uEOKPmShVuOo-ZWWEebebkw", "oQ3C4uFqrrTf4l8kq9FRovUPyU7o", "oQ3C4uJ5u10lknFAwQa4y4ZbJTJM", "oQ3C4uOJAgibWtOTdpwO4V1Iq48w", "oQ3C4uNcJ5r4ZX31-fb5QrmlpNto", "oQ3C4uABUnk6BugqZWOu4gSTX644", "oQ3C4uIqq30wfm5UNzj9NHc-l3h0", "oQ3C4uLpXeFabLejQ6JGxjwUEqZw", "oQ3C4uI5CTccs1HdpMhE6aaRfyLc", "oQ3C4uI9SpFV7wjRm1cGy654I_rw", "oQ3C4uC22O4_qJE4K6cyU6M84uQM", "oQ3C4uF-7hxnBvnPjAySXo3qwwww", "oQ3C4uH4Z114mTdLrLnLLjTIXaKU", "oQ3C4uK5uDYuh59tVcdqZcdfZzLM", "oQ3C4uI4k8cRZewXQWg1e7IdvSVI", "oQ3C4uFgxdLv9ToXJo9VMDcXcjRM", "oQ3C4uONZEMVVTQuLrl6cj3XzUkI", "oQ3C4uNq7SQHkPi_1k06Kbg6lXVA", "oQ3C4uM_0UlT_36ojDwFDjtxNF68", "oQ3C4uPrHS_SzyOfDaFHhVTxWZow", "oQ3C4uGfSWM_4PjMfYIrdA2O-W14", "oQ3C4uOlrwMOzxzuR9o9wEbBje4k", "oQ3C4uKbFgK3Ioac-6t1O4nXrMoE", "oQ3C4uP_QLkbL840tzB3P45jua3M", "oQ3C4uOgR_EI2rvtUnufYuSim2D8", "oQ3C4uDD96pLapTBU8KdmK2679eU", "oQ3C4uKGoahtr6ozLYpzEMK0tY8o", "oQ3C4uPAloQQU-SkxRTT3flP812Q", "oQ3C4uO__CC0UULWSFCyE84mJzI8", "oQ3C4uL8kV2mOEyEWN5NbRfXsmr0", "oQ3C4uMovGlvqgjZfiaSNB1g-jZ4", "oQ3C4uBThgpwhxAXRQmok1VgLLAY", "oQ3C4uFOJL6Yk22cJmqk_Y-1YAH0", "oQ3C4uL09hycyQ1dOk3YvM3fJeFg", "oQ3C4uBNxuO6IJwgIx5aliJjw39c", "oQ3C4uFJ-zjCEJ2tmBOfuVHyLVjI", "oQ3C4uOC19jeG3SaO-OJOzVGYtqo", "oQ3C4uFbSgUivK9kQvJ7HPvgqkeI", "oQ3C4uGppgj94QYqwjRztq65VDOI", "oQ3C4uP57Ct4WFYcBd7uUV9qDKOk", "oQ3C4uLgiQWoAI32S5WYPQR9BsqM", "oQ3C4uPJ4tTiJ0mNFMTx60rsbj4c", "oQ3C4uLtueFzAz5runggM6EHBTFw", "oQ3C4uOfajlgkpZNwiYIKbWEtC4Y", "oQ3C4uBg6yCTbPQnPplF4hYSzHAM", "oQ3C4uJ2e-oKkJne4w6GYk4pbEv4", "oQ3C4uJjtyaFI8Yj26kdbjdulPuM", "oQ3C4uCWiNYlyOB-ELsBWozcZ-20", "oQ3C4uPiIvd-uNThBnmK7zM7T3h8", "oQ3C4uOM9kwAEnPaZRiozNVtPkno", "oQ3C4uHmmWplGfK8TqfG2z6nLeXM", "oQ3C4uLZZlCbPBcbinkrnE487V-Y", "oQ3C4uD0HyTKvwgDVzsRQfw49hRc", "oQ3C4uC5BPWVSVP1hj507j57RbtI", "oQ3C4uD27nl4DGwPFS94AXmiw7zY", "oQ3C4uO_6TPqFau8V-iM4pd2llug", "oQ3C4uIkCycm1vvUv1XAWeMjBXwY", "oQ3C4uEz8jq8ue7eKPFd4Ef9lU4E", "oQ3C4uPBq3jjem-XWrx20-bZrKgE", "oQ3C4uJUi5VuKUF8DNpp7Y-pKVEk", "oQ3C4uDJ5fjxF8CosY56uv3dsTIE", "oQ3C4uG5ey6CYOHqILDhPqJ6JXaE", "oQ3C4uLL7BRQB0ZBQcsUVEsxuJx8", "oQ3C4uK7U9eYNMkoyFfxTM-hJcdk", "oQ3C4uI9K_fLO58jZHw2AXzjsEPU", "oQ3C4uOdlYGoABQi8taIQxDyKV74", "oQ3C4uNY4QquwCau9LR2po_xo1YE", "oQ3C4uBwjxZiwdZpXUvbYjjyyR2k", "oQ3C4uEM9ReQ4TWd-WBnGNpg6k64", "oQ3C4uEhiRay3RIENQ9PjD9SNPGU", "oQ3C4uHCXgUoy5nF6qS_mXIWd-0s", "oQ3C4uMI7FqJ4L6NbeiKbCknEfx8", "oQ3C4uPnw5DaZOeRPxFAozsPu6Uw", "oQ3C4uCxUFybMIweb6ObUekTHCvo", "oQ3C4uIZ-wnXMLbeoRz-aeiiNdfw", "oQ3C4uAesulf6_jqTKG04Et133GE", "oQ3C4uPMkiOslBhu6urWDiI-4r5g", "oQ3C4uPsRYeRj7Cdnw0S4tRLd2rk", "oQ3C4uHESE106ui0hTx4bhpEg_gY", "oQ3C4uAMPVAo8Zk7Aa_VedM9dvcE", "oQ3C4uHwPilEFvGRwlajc6jBO6CQ", "oQ3C4uAToHCXw7tjSZGQFuL70_4w", "oQ3C4uEmDS72ABqWmCeaQytFPgtU", "oQ3C4uP1WG2qwaKwSIe2Xc7gR1wM", "oQ3C4uAdXOvPpJK-89-GAfIFJxzY", "oQ3C4uItCcPDo5WUbeU9VHc5RzKk", "oQ3C4uNM2_ltROqGe1Ynaj1IQ58c", "oQ3C4uAek8WxsZocTMqyjYAnCdNg", "oQ3C4uPwKzSi5OvxhWeEli6H_T2k", "oQ3C4uMGWsF5IwuEczHVsayxmCUQ", "oQ3C4uFDzYHiAslzwPV7xdQFDbUg", "oQ3C4uDvWpBn50J2pf74ypFv1UAg", "oQ3C4uNfIJOBpkEBqop_WxzlRHso", "oQ3C4uJELCpWcBrmgUFw_1WpIORk", "oQ3C4uCSYressSl_CYeeEx3yP7x8", "oQ3C4uKAlbATqoqpHOXmqUZsXGBM", "oQ3C4uHJgc2ekT4PtWkBbyWUduNA", "oQ3C4uKfOlfoWJTo4EEYihXJ2Zpc", "oQ3C4uMJbmO2eQemSMjO5JGQUQOI", "oQ3C4uDVfoXbUof-TmAXT8KfH9yU", "oQ3C4uD5FrzWY5nXHK9KeWFCREt0", "oQ3C4uLtHKTHD55IhZtEEmbYt95k", "oQ3C4uBTpXlTmF4Xk9Z3oAhLI7C4", "oQ3C4uMMn5k-4k8wHQhb80aE1Y5M", "oQ3C4uEbN3OClHWhB3xx6V0y3J7w", "oQ3C4uIgfQMxNzJfn0NQyQkAq2MQ", "oQ3C4uBETGhpaUEocibDPu2hhJFU", "oQ3C4uDnI-eNY48WZYg0cxu1N5Mo", "oQ3C4uGZF2-MGCvzZeuGlcrkhkig", "oQ3C4uN4tf3gLv6V_V53NZEkJxpE", "oQ3C4uNhXCfaQYwb4f5aVxBVaTKM", "oQ3C4uHxIBpSkpbEgtmah2YpZhlQ", "oQ3C4uPp4EPqq2CBXIO1ofZg-8Gw", "oQ3C4uMz1QapIlc_iU_OhodzrcW4", "oQ3C4uH6_9YWed1Jy_o2f0n4rqlY", "oQ3C4uC2KdHEV_0t8VFCpmcsaQqM", "oQ3C4uDWl3VFNqEnU07uX0Or_80I", "oQ3C4uCAR2tKGVTuxblGqqGOQCvw", "oQ3C4uGWOitks6Kv143K50pAYIGU", "oQ3C4uAnKPf8aXI1gOVsLBXWoOww", "oQ3C4uOD7J2XWP-_IwAEcjBXuDBE", "oQ3C4uF0UOaxp4XfKpz8uQHCsRoM", "oQ3C4uFA-eckJVb7dB5wa-QT6PvA", "oQ3C4uFomsvUConevLm4RTKKE4To", "oQ3C4uASXR4kUibkenBOuK-WRWYU", "oQ3C4uJLfdWfezxryopeOG7aXl2Y", "oQ3C4uCLhLsN7Y_onh_7Gkh4_qTg", "oQ3C4uJLj8PZjhFA7rBnj4i74AwA", "oQ3C4uHGZ-rl5EkeHDYq6PCWRdmw", "oQ3C4uETZct67pX7WUqy-WB8nHbM", "oQ3C4uOvnElhF1Q9NQtjjGX5UVaE", "oQ3C4uKNzR_SxKnUrYnQ2tynR5HI", "oQ3C4uLfpqKYMcUzqbvzWZMMq-ks", "oQ3C4uHb35kB7hExo-zYNWTb3GHc", "oQ3C4uG-fbp8lKDT4KGxS7bdLmXc", "oQ3C4uMxQYHo8uLiMr69a3zhvCsc", "oQ3C4uEROFQsqSnsjBLNUh8oIA9c", "oQ3C4uF6n4sNhM20yDsDk4iAG1L4", "oQ3C4uE7IZ1OMfsTZMWBN6wcLVds", "oQ3C4uH_kS0vRzSPMIaqnzIJch7A", "oQ3C4uNBUYEYs-1rjtzWg8n8sCAU", "oQ3C4uCG2Dnu-hNnhpMgE1SrbwHA", "oQ3C4uKXy7Kpd_DOwrq16LZIdoVQ", "oQ3C4uEmTUlNA7nPlEMJxGQLR7Pw", "oQ3C4uOatklCRgCMIE3RKohvM39o", "oQ3C4uAICWrrwoc3bO_9F5A69lzY", "oQ3C4uCLDvSCBAe8sDoHKH_MWnUg", "oQ3C4uKRppjl9C_mP6HBIovJ-ROM", "oQ3C4uHLaBEdqOZhkomBmQcLm6N0", "oQ3C4uFnL38IrgRixuX0_g26Zsao", "oQ3C4uP-k33at1s5-Sd3vW5_k240", "oQ3C4uJicQGkxau1may-eFGIv1k8", "oQ3C4uAt6kwibHnBE4JRwrFtK1BA", "oQ3C4uHd4iRqcydr8_llAjPFTpYM", "oQ3C4uM7l458u2h91PVpPy4zl52o", "oQ3C4uBvSZ5Iumx4UQ-8tW3j_igU", "oQ3C4uPzowaMI-iVXEuqnRis3ATQ", "oQ3C4uC3pknKQNLJ3RFZdL-INkqE", "oQ3C4uMUBlTeVHCCyw-QWfO0P-Cs", "oQ3C4uMv08QbKETyjIsP259Ql47g", "oQ3C4uEuk2rnPj6sklU9dq1FXWS4", "oQ3C4uEdhDS4F9CuFhE49L6AmlvU", "oQ3C4uHx6xglD5doVIi6r2AoEXfM", "oQ3C4uA65jCcu3JUUZSZwIm8BJmM", "oQ3C4uPijqBSVfx35mgp_Zz1caJg", "oQ3C4uAwss1VRpLlk-vQ5-KVNq4o", "oQ3C4uJCzCHY_b9orwXBFst8MhuE", "oQ3C4uJNKrrtwyg2Ty1AQ2tQU508", "oQ3C4uOp9S1GbTX3wJak2qrnyKWg", "oQ3C4uG64mc52mPP-TCnRqfoDXm8", "oQ3C4uMiqnQJZhPnsL9tyIiKgRbI", "oQ3C4uLzENgsMp-8Zh3NrLUuwERU", "oQ3C4uCeAUxTArJliViTUBrrSR50", "oQ3C4uIVbDwPyib3Zxh_e66lTGP0", "oQ3C4uHCSY3QOKzjcIsW1vSUe-60", "oQ3C4uMeuI-ct59H7Vkj6HXjGtDw", "oQ3C4uMN_HbLqdTdHZ2w9tBF-CuE", "oQ3C4uK1KPMpSmErnx5NCznMpk2g", "oQ3C4uOfajGQwgQ3DENJKiYEGj5I", "oQ3C4uH08vjsbIwbNt90_V5VGeak", "oQ3C4uDJak2CliXNCRj3Mn34AIs4", "oQ3C4uMisb-jgmvWs_rL7EffXfdc", "oQ3C4uJ0gcnZrynQdgyUZ6R--QLs", "oQ3C4uDJmi6VwdTUFE3GTr9Go1wg", "oQ3C4uGTVuK0Jq6_NE6r5Y1WNMaQ", "oQ3C4uKg3uxNi6jOJU6zuVrXwkX4", "oQ3C4uB1Ihu4l384zdSkagoOo1wQ", "oQ3C4uJV9tT-QQP1-Kqh-ZjSdAUQ", "oQ3C4uGMD7nb83G6FEAHooiHdBJo", "oQ3C4uDjQw_f5c5yaqAfl2ggeJV4", "oQ3C4uCYSxi7WT9736LwX4-WHtsI", "oQ3C4uE7ZwP7HN-g78zL_2ZhcW4Y", "oQ3C4uFCbWcCbwtZIv_5u8R2KMyc", "oQ3C4uGjsFAnLOiiIZFV7IN-kzh8", "oQ3C4uOAkCg7oB95YDQo5j8Tbg-o", "oQ3C4uNDAFf8wbrOhupXQ1ULCCVI", "oQ3C4uB6iYypvbruXO8P683p_Yc4", "oQ3C4uAOQY8flFujO_HGJulsU7XY", "oQ3C4uCT4XHCkFfVvu76ZfVFJTd0", "oQ3C4uLy_lZUvfGZFqia9vo1ASm4", "oQ3C4uIpgrNi5Z_8dFvL5nHbMdCc", "oQ3C4uKivEsBGcOj2KGQp6B1BiEk", "oQ3C4uJlUgqtwiCo-kI8dzIQsGi0", "oQ3C4uGEIEZpzJM-NbibM1me_7nA", "oQ3C4uPSkD5a2AUiM14E0Kfj6lZY", "oQ3C4uP9KE5vq0IDF--JreU-2zL0", "oQ3C4uJ-kpQMG4jFKvruJLHFXUEc", "oQ3C4uPO3c0pEBAlARrAvh7E4s88", "oQ3C4uD_tRBLh59YCXxzKxRjfPZI", "oQ3C4uObH_wL9DJMT5yelc0Gi3Yw", "oQ3C4uEoVQCqoFW7s7fS7_hLvtiA", "oQ3C4uFajPcUqgoFzoXd076vk2e0", "oQ3C4uDGrDTBhFTz5uOff2JA2xOA", "oQ3C4uHWt0ou4TKJ9JmmM9uLhxxQ", "oQ3C4uFQJtPyFJhQnm_ab4Qr6muw", "oQ3C4uLe39yOwtlUFoTCZ4ZRXqXE", "oQ3C4uCdwOwCbe6oKGlQZYKCuP14", "oQ3C4uGdA-DzvCvYFFrO_5psNETc", "oQ3C4uJzVzRU_aeqBs88vDRH4o1M", "oQ3C4uHlMGKR-pIBvLIIpzwUbjCg", "oQ3C4uBfuNEMn3pEDjwErGguvgiA", "oQ3C4uB5-TQQszv0NRRaiOwu0dJQ", "oQ3C4uMYi7p1ZVNbXxEBX7ff4l8I", "oQ3C4uCOj1c6EYl0fwkbNA_Edh7U", "oQ3C4uI7dQUoelLgmiOKPQYmvpNA", "oQ3C4uEshm7n2607W8rKbkfJw_As", "oQ3C4uPWh_UDDi26yCwUwTtIgh7A", "oQ3C4uGlqIEv8crboB2zqbXBcD1k", "oQ3C4uKTMutXinm0jRTuf5UWZYNc", "oQ3C4uAEnr2WW3LUZGj8c-ibBiYo", "oQ3C4uPdV7hc51v23rXRBxXlPjnY", "oQ3C4uGGBcJq-RiNOpOdfUbF08UM", "oQ3C4uKjpf4gdplueiVJDFY1BSSA", "oQ3C4uOrpt5S_C_xMvTrzflW6NCw", "oQ3C4uGwUBHkPx5PRimtLjaA2eqA", "oQ3C4uIhQTvCELBGIbm3AHndTvzg", "oQ3C4uKdscjd9GpQ0Op0d9A0xXx8", "oQ3C4uCQvSUtB6-6SrZMi3D-01qM", "oQ3C4uOrYKQoR1GLqM6vkyTn2IVs", "oQ3C4uOi63HFbWTAMLzX_QKiSRYM", "oQ3C4uN_8tOuJj8lLt9en1nGYXLE", "oQ3C4uGqHbziaFHfNKAm0OzNPHkM", "oQ3C4uPji8OxgQbuHT_UCzzkdnT4", "oQ3C4uM8UGmmFH6t9utW4pUN0SGM", "oQ3C4uIKFum23DkEXRSk0HT0cfRc", "oQ3C4uIUZw_1RFBBMXBQtsGFYDDI", "oQ3C4uDOsSwsazzVkzbZZMsA61MY", "oQ3C4uJP9qWNRW_pqLm_qnYeaz_s", "oQ3C4uIFEqzSNV9DNYsuZyElmlYM", "oQ3C4uKuZQhhR7AGvrsv5otdP3qk", "oQ3C4uCu8vqy8_OWwoBcBWrsBtxg", "oQ3C4uL4UERYwXvm4k8sVlrvZg1k", "oQ3C4uChs0XkF_paooo_qLsM5TAY", "oQ3C4uAP26LurHLU54kfzrTERRKU", "oQ3C4uPKoSr90_5fgun9wdOLkBnQ", "oQ3C4uCkIt7VRAoBcg-cNcbZKejo", "oQ3C4uPjKJwsyjWSSnT5fLoZGQqc", "oQ3C4uHB6Lag6y8JGjfpx-kc5FXU", "oQ3C4uCNesyivo9zJgjM41S4kBY0", "oQ3C4uF8-9m-ZmzgaehFnPpicaqM", "oQ3C4uLCc0gssT7Fq2ocS0Bp7vsM", "oQ3C4uNkQjBkgGI41ZbtqNyI2xVw", "oQ3C4uOu9fLeVuZYY9-qqBDSgNDI", "oQ3C4uCrPMfBE6A1pc_awtrZcsG8", "oQ3C4uJl-AXIrLTviNGnJ1m9sns4", "oQ3C4uMAD7wndSb4n9nfbiBLMZVs", "oQ3C4uKGOeexIX4o36R2tl-ei7ZA", "oQ3C4uM6cidMiZpOoZ_o4q6RLEdQ", "oQ3C4uA38U6lkN31uJsyTTD7yUJY", "oQ3C4uPjcXqNmpJg-gaDi1m6BZTU", "oQ3C4uDQSka0S1FSxBYDn_jsxXXs", "oQ3C4uEr58VJw4VgbSh9U1HB1TvM", "oQ3C4uAFNIZXTiBkoglhHAp3nQ70", "oQ3C4uA4logqc01cmbztFKa1DHnM", "oQ3C4uBgDDfG_9j3PYQ-R9vTEzDg", "oQ3C4uDhaCAMAGcd9bDSAE6CRfTc", "oQ3C4uBG5Te-NLucwk5Q7s9XWgYI", "oQ3C4uDjtAGftfzu3eqU7RdDCmAI", "oQ3C4uGNIW8tUTnxYRn-_-T1yCSU", "oQ3C4uOaoErFkhbtI8-OAeT5UDWM", "oQ3C4uKW5rRayCTv0XSxsxPgiK5k", "oQ3C4uA_gqyTM3Qd1MMaVPelWfRE", "oQ3C4uEgQAIW6S1oTSXpTttL3xUo", "oQ3C4uHYS4uBtlO0rIWSMiLA3bbQ", "oQ3C4uKlLeckCPfvPj8C8xCHwDFk", "oQ3C4uMnuPJErKrukW9p8UpVYgj4", "oQ3C4uCko8oVOoZcfN2hGBm5hk_Q", "oQ3C4uEfPaWGyTR970dyaB5RmdIg", "oQ3C4uItzJv8lkZYiaOf6lFIAyKs", "oQ3C4uOZ87zl9Iy0uf1RmbGmaTvk", "oQ3C4uKa7hlvxUfd-IZz5yEAj1UQ", "oQ3C4uFk3t0KHxuk0yPpwcn4B8Ek", "oQ3C4uH1Xo-GB-x7en5WG3jLfGXg", "oQ3C4uGUn6iLS4l5QJ4jrzJnl2Uw", "oQ3C4uNXWNn8AhBkFHAIVi09Nfd4", "oQ3C4uM3UtP1L-EHFj4okXWkefzY", "oQ3C4uDh_viwPElTzWO5dvT-Je9A", "oQ3C4uMOxX_Fa8AkJlX0kbhw-lz4", "oQ3C4uImjNS5q-xmEaPTU0iXgg20", "oQ3C4uHSU2KHAUvkj45EPvSo2CZM", "oQ3C4uBGtByjAnnELcYkla-LXd_Q", "oQ3C4uDIdJA0olDni6Jw0HAffHPc", "oQ3C4uNXkOVfJcJbYVugcj0F0Ejk", "oQ3C4uJuFd5HF5jlwjl0qaAJzjp8", "oQ3C4uJuC80_QY897JuRYiIE5WkY", "oQ3C4uBOULmvrZYgzxj1E0Udiaio", "oQ3C4uOzUWQGg2_qiHEwI61G3zdg", "oQ3C4uAd3YYdX8HUBFILri5N7NiA", "oQ3C4uARFQIAkUok-SCYN0Knc_xk", "oQ3C4uF1FfM4e8lueCpJZiK55H3w", "oQ3C4uI07KrQh7OP8vjiWaEedDjc", "oQ3C4uGV7MnmYFFUH81k-4dYWgFs", "oQ3C4uCoKC7v5ESmmr_CDdnT6Wwc", "oQ3C4uOXCCmJKcd8uaauKN9e7DX0", "oQ3C4uIpNZJIZ29nkpqOOHr6n7ok", "oQ3C4uEg0bVib8Ri7nT5aC4nYupM", "oQ3C4uOWbvvseENLbIjLMOLkOCG4", "oQ3C4uMmow6_E-PMuh-93nXlrH1o", "oQ3C4uMH4tX9uuhlpx6a7f0aQsV8", "oQ3C4uG5d89hs83WAcBMCyf0eTuY", "oQ3C4uBGKOw95ppB2kVsMubeFe4g", "oQ3C4uF7Os_eivU-UY0MRlOpgPcE", "oQ3C4uMOX0BqwS8OfGq9i_LTTILk", "oQ3C4uA3PHgADjV81X5gH5RjPCkM", "oQ3C4uL_RZP0Xsx8p51OZ8dHQz1g", "oQ3C4uP0nURiNWuwjfiMqUg-MkTE", "oQ3C4uKtkcQYhey9MIqueI-R59jM", "oQ3C4uD6YLRgqfmPOYiBW_T6PgNY", "oQ3C4uLNaAW3HugpusGbxYQrcM7g", "oQ3C4uGg15nPmiN3DfW-aqNZ3JKo", "oQ3C4uDSjg5gqfq6Z3z8iiT8NecM", "oQ3C4uC6SjmQ-05JTFy5aC12kfjk", "oQ3C4uGgXmUkrFk6zRHdoDNea8CU", "oQ3C4uCdWzsQD_2YRGgwR500F_ms", "oQ3C4uN8a62YxlqnQU71Ar_WELF8", "oQ3C4uEdklM0L99Lvfgvmtfma6ac", "oQ3C4uNPJRaMIAEhsStn3hTFAJa4", "oQ3C4uDLBcufsdc_AkFMm1td86Jw", "oQ3C4uOUSAFaPEaDWXPoW3gYliEQ", "oQ3C4uKzNfDRLiTJ6ueEeZeYxd7E", "oQ3C4uMujwve_RFtkj4h3W0FCwH4", "oQ3C4uDEzH81ZLIQer3-_EklRXLs", "oQ3C4uFQFFj816vFCzcDSsYegYmI", "oQ3C4uCUXYWU8iW2D4NH_l4e8VQE", "oQ3C4uIlPDg_SYqVLgC8WqFM42CA", "oQ3C4uB2uqfNBNbJysmsr24XCnPQ", "oQ3C4uKqkQ_K7MIYiC1OklIAN18c", "oQ3C4uC-xxeEVm65DQ9Dd8OrWSak", "oQ3C4uKIyX7ci3dWu9hgObKCf094", "oQ3C4uEQMPlh3f9RnyKv2Eg2fEjg", "oQ3C4uDmczjtzLiZ1gn0dzTlwOmg", "oQ3C4uKhwSHYYCGz9V5EdpKFRRW8", "oQ3C4uA2StlTRvO6Jes9Bq6JyOyc", "oQ3C4uKpdjsg6hr_2-FJSxC__GCo", "oQ3C4uMg9-PnbJ051HpArj1pIZOQ", "oQ3C4uMnsTexFzkRuHN7gcXlXqdg", "oQ3C4uBzrBMGs9wkMbU8Bji1sLiM", "oQ3C4uIZ7t0GQcPld8IumP6nGDxY", "oQ3C4uDu0NczRt3hhTQdovwj66PY", "oQ3C4uIvqxXDEckUqX2nIQGg9nps", "oQ3C4uLsd8i-CyCDZCWVmQB7Jlsw", "oQ3C4uGw8oJlye85wlJbzaj04y2s", "oQ3C4uA0PF5onJXu5tY92AOt5xK0", "oQ3C4uP-ZNaZuhzVMhx8LCOdE8bU", "oQ3C4uKAhYJXZbRiaVmI1s01MUlw", "oQ3C4uILny3wiC0uue4mR8Y3U8JM", "oQ3C4uMtC9m-mzM6QFpqYdVK7u74", "oQ3C4uGwvYkLDImCTYPqFMgnuJpY", "oQ3C4uGqsMq9aAx9wXRDNDZHUnN4", "oQ3C4uHx3h5UHOD_FUc6k9n0Sn54", "oQ3C4uCT9T077-S_IzmjzBqEVjCA", "oQ3C4uK7qpbRR5CqqS_LCZcxpaxQ", "oQ3C4uIoQtJ_QRYsj_iz0hfP5TaA", "oQ3C4uMbQ64sxLS2Xr5kYK9Kk324", "oQ3C4uLKUxxrwz9Kx1hDXRdC9cpI", "oQ3C4uAUKOxMYc4vK9RTuuijlSk8", "oQ3C4uLcEk_rtOe0fX4mYA131Ztw", "oQ3C4uKDC6QSkQ6yEAV2KhPNJolU", "oQ3C4uC6XttJswsKQjWvXbp-tCTQ", "oQ3C4uNXdM9MGXCa15SL9coybydY", "oQ3C4uHe6jjsir_mHp2cJVuFol2U", "oQ3C4uH6Cn3L1gKFzhRTQyC5i86Q", "oQ3C4uK4D2OWhUSJTMOuzIvrCxwc", "oQ3C4uJOeu57ibkUlbpgGjFOAFLc", "oQ3C4uH_J5lK2gjcH5mglbOEIuJA", "oQ3C4uPY8eyXdF87AlVTpMf6DjW4", "oQ3C4uMAHEKm0gI6gFNwlx8xpysY", "oQ3C4uMq0rpApH2FgkuwWJYfz8o8", "oQ3C4uIIl0RPfap2iOmKwyU9k0nk", "oQ3C4uGy1ftzzVpAdEefp6lcAjTI", "oQ3C4uF5s1FFUwyIpO7tAw_m1k2k", "oQ3C4uHynGIha8yDpGGaPJAdE1gc", "oQ3C4uExE80JMnr1B2SYcnHD--r8", "oQ3C4uJ7wH7VK4yWD_QqdTX3w-sw", "oQ3C4uHSmfWiKanjnh0wqvOh8lcg", "oQ3C4uPpZzUj2OGrziNIoTgxAYj0", "oQ3C4uNhnHWSouvaZKoSr_zPki2E", "oQ3C4uJLHIFaBEM-5eZS1wHJQqTM", "oQ3C4uLCzDN0CSz4s4m-Y7zyDNlk", "oQ3C4uAgaQhJNK5g2rAiKcuDpgd0", "oQ3C4uH_IAbZqQJJj0WHo629kUMs", "oQ3C4uDZbk8b2kqop1A8j1m8bym0", "oQ3C4uCWGuUA_dQMBTVrlY6miWDk", "oQ3C4uB8WmRbDN-wK-aoV8QQPXmE", "oQ3C4uC_IG9rFoU_7kh_RPSxKLDo", "oQ3C4uPFIYjmnX1T2Oh6sDR2Oah4", "oQ3C4uKq-Teti7R3f8qbwCd1eebQ", "oQ3C4uFBueUp879IVmOovG_zcSm0", "oQ3C4uEj0YgV5reDXBjesEThridg", "oQ3C4uFVXkTtH2GHkhjxsaFbDgRw", "oQ3C4uJzy9i58XRS3YbvUnUeTr-o", "oQ3C4uBAoNFimw9rS-dB0WwZo1ds", "oQ3C4uP_1PKhJ8hKJiTV0IXKnnaE", "oQ3C4uNEgTsPEf5rhCE2vvOlQcjs", "oQ3C4uBrcMa4nXYiatWK3Qg_47-8", "oQ3C4uL3ku-e4bIm89UE_ju-z0oc", "oQ3C4uFiiQv7x_JS_M8D9LcT89Bc", "oQ3C4uND_nK4H4KdEsVgMSBA6GmM", "oQ3C4uDY0eL8HpnOfCVRV90lGXZ4", "oQ3C4uLeft6H0nXEbyeSoLYDtt88", "oQ3C4uD-AAkPc4oynHNkxvE6GOEc", "oQ3C4uMdCf34T9FOpgrj_CwRl8xI", "oQ3C4uMaQwPBu-S_B2ZWI-TwiZNk", "oQ3C4uMopaeSpGeeVC1DJKkZZmaA", "oQ3C4uOjHmkBAYvVJsvbVYufJWl0", "oQ3C4uIIQHOvjfm7PHzhgpMLYDcw", "oQ3C4uMzp6YPaxjMCS08YOSyzKU4", "oQ3C4uENxhog4qDAp9NwUSwC07LY", "oQ3C4uN0T2fDi8M7uGhxn0YrMpx4", "oQ3C4uMP3JKFEykEovtCMdWEUTdI", "oQ3C4uNnHQbyJB9al0QOyX5eskeQ", "oQ3C4uCKcYKt6q_BhgziXQsNdqTI", "oQ3C4uGmYUOnJWNiCX7EHp9m30lo", "oQ3C4uHeiwCn9y3cTHJKvTb3Tji0", "oQ3C4uCKxMVuXkym7c2b6ZtDkBHI", "oQ3C4uBgpD07T7zTS5e4I1BUm5xo", "oQ3C4uI43N9NcCUcaWh9yVNO8mW8", "oQ3C4uHyrWakzr83-SNmUtQGisXQ", "oQ3C4uAY6WHAniAw_RHAZYksb0nM", "oQ3C4uEUC5mHY0vUBM4WCERjqkiA", "oQ3C4uHxlJOhkCdZb8siftIzNFHU", "oQ3C4uG4tDGDADG0GmWQRzkBz580", "oQ3C4uH_4Gu00nbxLr7JBhDPAkKk"};
        ResponseInfo responseInfo = messageService.sendToUsers(users, MessageType.TEXT, "调试群发接口....勿回");
        if (!responseInfo.isSuccess()) {
            System.out.println(responseInfo.getInfo().getErrorCode());
            System.out.println(responseInfo.getInfo().getErrorMessage());
        }
        Assert.assertNotNull(responseInfo);
        Assert.assertTrue(responseInfo.isSuccess());
    }
}