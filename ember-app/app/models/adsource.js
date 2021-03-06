import DS from 'ember-data';

export default DS.Model.extend({
    name: DS.attr('string'),
    description: DS.attr('string'),
    type: DS.attr('number'),
    numbers: DS.hasMany('number', { async: true }),
    site: DS.belongsTo('site')
});
