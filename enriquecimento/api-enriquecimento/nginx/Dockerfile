
FROM nginx:1.19.6-alpine
#remove o arquivo defalt da imagen
RUN rm /etc/nginx/conf.d/default.conf
# add novo arquivo
COPY nginx.conf /etc/nginx/conf.d/default.conf